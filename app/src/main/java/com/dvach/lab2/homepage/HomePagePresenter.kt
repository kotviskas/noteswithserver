package com.dvach.lab2.homepage

import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.recyclerAdapter.RecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomePagePresenter(var view: HomeFragmentView?) {
    var model = HomePageModel()
    lateinit var adapter: RecyclerAdapter

    fun whenFloatingActionButton() {
        view?.navigateToCreateNote()
    }

    fun whenExit() {
        model.deleteToken(view!!.requireActivity())
        model.clearDatabase(view!!.requireContext())
        view?.startSplashActivity()
    }

    fun noteClick(task: Task) {
        view?.navigateToAboutNote(task)
    }

    fun changeCheck(task: Task) {
        model.changeTaskDone(task, view!!.requireContext(), view!!.requireActivity())
    }

    fun whenSwiped(viewHolder: RecyclerView.ViewHolder) {
        GlobalScope.launch(Dispatchers.IO) {
            model.whenSwiped(viewHolder, view!!.requireContext(), view!!.requireActivity())
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
        }
    }

    fun onViewCreated() {
        view?.setRecycleParameters(adapter)
    }

    fun onResume() {
        model.loadText(view!!.requireActivity())
        //получение тасков
        GlobalScope.launch(Dispatchers.Main) {
            var items =
                withContext(Dispatchers.IO) {
                    model.getItems(view!!.requireContext(), view!!.requireActivity())
                }
            adapter.notifyDataSetChanged()
            if (items.size != 0) {
                view?.showNotes()
            } else {
                view?.showPlaceholder()
            }
        }
    }

    fun onRefresh(){
        GlobalScope.launch(Dispatchers.IO) {
            model.synchronize(view!!.requireContext(), view!!.requireActivity())
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
            view!!.stopRefreshAnimation()
        }
    }

    fun onDestroy() {
        view = null
    }

    fun onCreate() {
        setAdapter()
        GlobalScope.launch(Dispatchers.IO) {
          //  model.synchronize(view!!.requireContext(), view!!.requireActivity())
            withContext(Dispatchers.Main) {
                adapter.notifyDataSetChanged()
            }
        }
    }

    private fun setAdapter() {
        adapter = RecyclerAdapter(model.getItemsArray(), view!!, view!!)
    }
}