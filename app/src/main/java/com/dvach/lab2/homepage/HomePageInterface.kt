package com.dvach.lab2.homepage

import android.content.Context
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Priority
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.recyclerAdapter.RecyclerAdapter
import java.util.*

interface HomePageInterface {
    interface View : RecyclerAdapter.OnCheck, RecyclerAdapter.OnItemClick {
        fun showNotes()
        fun showPlaceholder()
        fun stopRefreshAnimation()
        fun navigateToAboutNote(task: Task)
        fun startSplashActivity()
        fun setRecycleParameters(adapter: RecyclerAdapter)
        fun navigateToCreateNote()
        fun getContextT() : Context
        fun getActivityF(): FragmentActivity
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
        fun onCreate()
        fun whenFloatingActionButton()
        fun whenExit()
        fun noteClick(task: Task)
        fun whenSwiped(viewHolder: RecyclerView.ViewHolder)
        fun onResume()
        fun onRefresh()
        fun changeCheck(task: Task)
    }
}