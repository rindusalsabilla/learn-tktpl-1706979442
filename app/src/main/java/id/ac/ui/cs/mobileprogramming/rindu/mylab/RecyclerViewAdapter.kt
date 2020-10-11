package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.rindu.mylab.databinding.TaskListItemBinding

class RecyclerViewAdapter(private val list: List<Item>) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }

    fun setListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun getItemAt(position: Int): Item {
        return list[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<TaskListItemBinding>(
            inflater,
            R.layout.task_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.day.text = list[position].day
        holder.binding.task.text = list[position].task
        holder.binding.taskListItem.setOnClickListener{

        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder( val binding: TaskListItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        val container = binding.root

        init {
            this.binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            listener!!.onClick(v, adapterPosition)
        }
    }
}
