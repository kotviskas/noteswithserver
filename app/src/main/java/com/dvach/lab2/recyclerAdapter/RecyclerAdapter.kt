package com.dvach.lab2.recyclerAdapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dvach.lab2.pojo.Category
import com.dvach.lab2.pojo.Task
import com.dvach.lab2.R
import com.dvach.lab2.models.Item
import kotlinx.android.synthetic.main.add_task.view.*

private const val POST_TYPE_HEAD: Int = 0
private const val POST_TYPE_NOTE: Int = 1

class RecyclerAdapter(
    var listItems: ArrayList<Item>,
    var listener: OnItemClick,
    var listener2: OnCheck
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClick {
        fun noteClick(task: Task)
    }

    interface OnCheck {
        fun changeCheck(task: Task)
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var headText = itemView.findViewById<TextView>(R.id.mainTextView)
        var textText = itemView.findViewById<TextView>(R.id.textTextView);
        var checkBox = itemView.findViewById<CheckBox>(R.id.checkBox);


        fun setNote(task: Task) {
            headText.setText(task.title);
            textText.setText(task.category.nameCategory);
            checkBox.isChecked = task.done==1

            itemView.cardView.setCardBackgroundColor(Color.parseColor(task.priority.color))
        }
    }

    class HeadViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var headText = itemView.findViewById<TextView>(R.id.mainTextView2)

        fun setText(category: Category) {
            headText.setText(category.nameCategory);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == POST_TYPE_HEAD) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.add_category_name, parent, false)
            return HeadViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.add_task, parent, false)
            return NoteViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }



    fun setList(list : ArrayList<Item>) {
        listItems = list
        notifyDataSetChanged()
    }


    fun deleteItem(position: Int) {
        listItems.removeAt(position)

        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return if (listItems[position].type == 0) {
            POST_TYPE_HEAD
        } else {
            POST_TYPE_NOTE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == POST_TYPE_HEAD) {
            (holder as HeadViewHolder).setText(listItems[position].note_object as Category)
        } else {
            (holder as NoteViewHolder).setNote(listItems[position].note_object as Task)
            holder.itemView.setOnClickListener {
                listener.noteClick(listItems[position].note_object as Task)

            }
            holder.itemView.checkBox.setOnClickListener {
                if ((listItems[position].note_object as Task).done == 0) (listItems[position].note_object as Task).done = 1
                else (listItems[position].note_object as Task).done = 0
                listener2.changeCheck((listItems[position].note_object as Task))
            }
        }
    }
}