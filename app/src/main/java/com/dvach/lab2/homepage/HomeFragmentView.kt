package com.dvach.lab2.homepage

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.MainActivity
import com.dvach.lab2.homepage.HomeFragmentViewDirections
import com.dvach.lab2.R
import com.dvach.lab2.SplashActivity
import com.dvach.lab2.recyclerAdapter.RecyclerAdapter
import com.dvach.lab2.pojo.Task
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher


class HomeFragmentView : Fragment(), HomePageInterface.View{


    lateinit var presenter: HomePageInterface.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePagePresenter(this@HomeFragmentView)
        presenter.onCreate()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()

        floatingActionButton.setOnClickListener {
            presenter.whenFloatingActionButton()
        }

        exitImage.setOnClickListener {
            presenter.whenExit()
        }

        swipeRefreshLayout.setOnRefreshListener {
            presenter.onRefresh()
        }

        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int
                ) {
                   presenter.whenSwiped(viewHolder)
                }


            }
        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)

    }

    override fun onResume() {
        super.onResume()
       presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showNotes(){
        imageView.visibility = View.INVISIBLE
        textView.visibility = View.INVISIBLE
        recyclerView.visibility = View.VISIBLE
    }

    override fun showPlaceholder(){
        imageView.visibility = View.VISIBLE
        textView.visibility = View.VISIBLE
        recyclerView.visibility = View.INVISIBLE
    }

    override fun stopRefreshAnimation() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun noteClick(task: Task) {
        presenter.noteClick(task)
    }

    override fun navigateToAboutNote(task: Task){
        val action =
            HomeFragmentViewDirections.actionHomeFragmentToAboutNoteFragment(
                task
            )
        findNavController().navigate(action)
    }

    override fun changeCheck(task: Task) {
        presenter.changeCheck(task)
    }

    override fun startSplashActivity(){
        startActivity(
            Intent(
                requireContext(),
                SplashActivity::class.java
            )
        )
        requireActivity().finish()
    }

    override fun getContextT(): Context {

            return requireContext()

    }

    override fun getActivityF(): FragmentActivity {
        return requireActivity()
    }



    override fun setRecycleParameters(adapter: RecyclerAdapter){
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        recyclerView.adapter = adapter
    }

    override fun navigateToCreateNote(){
        val act =
            HomeFragmentViewDirections.actionHomeFragmentToCreateNoteFragment()
        findNavController().navigate(act)
    }


}
