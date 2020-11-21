package com.dvach.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.adapter.RecyclerAdapter
import com.dvach.lab2.models.AppDatabase
import com.dvach.lab2.models.Item
import com.dvach.lab2.models.Task
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), RecyclerAdapter.onItemClick, RecyclerAdapter.onCheck {

    lateinit var sPref: SharedPreferences

    var flag = false
    lateinit var items: ArrayList<Item>
    lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // user = intent.getSerializableExtra("user") as User
        floatingActionButton.setOnClickListener {

         //   i.putExtra("user", user)
            findNavController().navigate(R.id.createNoteFragment)
        }
        exitImage.setOnClickListener {

            sPref = requireActivity().getSharedPreferences("kek", Context.MODE_PRIVATE)
            sPref.edit().remove("userEmail").apply();
            sPref.edit().remove("userPassword").apply()
            startActivity(
                Intent(
                    requireContext(),
                    SplashActivity::class.java
                )
            )
        }
    }

    override fun onResume() {
        super.onResume()
        flag == true
        super.onResume()
        items = ArrayList<Item>()

        //   Toast.makeText(this,"sdas",Toast.LENGTH_LONG).show()
        var list = AppDatabase.getDatabase(requireContext()).CategoryDao().getCategoriesWithNotes()
        list.forEach {

            items.add(Item(0, it.category))
            it.tasks.forEach {
                items.add(Item(1, it))
            }

        }

        if (items.size != 0) {

            imageView.visibility = View.INVISIBLE
            textView.visibility = View.INVISIBLE
            recyclerView.visibility = View.VISIBLE
        } else {
            imageView.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            recyclerView.visibility = View.INVISIBLE
        }

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 1)
        adapter = RecyclerAdapter(items, this, this)
        recyclerView.adapter = adapter

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


                    var pos: Int = viewHolder.adapterPosition

                    if (items[pos].type == 1) {
                        AppDatabase.getDatabase(requireActivity().applicationContext).NoteDao()
                            .delete(items[pos].note_object as Task)
                        items.removeAt(pos)
                        //adapter.deleteItem(pos)

                        adapter.notifyDataSetChanged()
                        // adapter.notifyItemRemoved(pos)


                    }
                    //  adapter.notifyItemRemoved(pos)
                }

            }

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }
    override fun noteClick(task: Task) {

     //   i.putExtra("note", note)
     //   i.putExtra("user", user)
        findNavController().navigate(R.id.aboutNoteFragment)
    }

    override fun changeCheck(task: Task) {
        AppDatabase.getDatabase(requireContext()).NoteDao().insert(task)
    }

}
