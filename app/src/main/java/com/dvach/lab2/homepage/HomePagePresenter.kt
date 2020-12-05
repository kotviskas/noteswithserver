package com.dvach.lab2.homepage

import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.recyclerAdapter.RecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePagePresenter(var view: HomePageInterface.View?) : HomePageInterface.Presenter{
    var model = HomePageModel()
    lateinit var adapter: RecyclerAdapter

    override fun whenFloatingActionButton() {
        view?.navigateToCreateNote()
    }

    override fun whenExit() {
        model.deleteToken(view!!.getActivityF())
        model.clearDatabase(view!!.getContextT())
        view?.startSplashActivity()
    }

    override fun noteClick(task: Task) {
        view?.navigateToAboutNote(task)
    }

    override fun changeCheck(task: Task) {
        model.changeTaskDone(task, view!!.getContextT(), view!!.getActivityF())
    }

    override fun whenSwiped(viewHolder: RecyclerView.ViewHolder) {
        GlobalScope.launch(Dispatchers.IO) {
            var context = withContext(Dispatchers.Main){view!!.getContextT()}
            var activity = withContext(Dispatchers.Main){view!!.getActivityF()}
            model.whenSwiped(viewHolder, context, activity)
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onViewCreated() {
        view?.setRecycleParameters(adapter)
    }

    override fun onResume() {
        model.loadText(view!!.getActivityF())
        //получение тасков
        GlobalScope.launch(Dispatchers.Main) {
            var items =
                withContext(Dispatchers.IO) {
                    model.getItems(view!!.getContextT(), view!!.getActivityF())
                }
            adapter.notifyDataSetChanged()
            if (items.size != 0) {
                view?.showNotes()
            } else {
                view?.showPlaceholder()
            }
        }
    }

    override fun onRefresh(){
        GlobalScope.launch(Dispatchers.IO) {
            if (model.synchronize(view!!.getContextT(), view!!.getActivityF())) {
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
                view!!.stopRefreshAnimation()
            }

        }
    }

    override fun onDestroy() {
        view = null
    }

    override fun onCreate() {
        setAdapter()
        GlobalScope.launch(Dispatchers.IO) {
            if (model.synchronize(view!!.getContextT(), view!!.getActivityF())) {
                withContext(Dispatchers.Main) {
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun setAdapter() {
        adapter = RecyclerAdapter(model.getItemsArray(), view!!, view!!)
    }
}