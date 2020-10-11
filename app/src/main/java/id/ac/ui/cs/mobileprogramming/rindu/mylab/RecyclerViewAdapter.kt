package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.rindu.mylab.databinding.BuildingListItemBinding


class RecyclerViewAdapter(
    private val list: List<Item>,
    private val viewModel: SharedViewModel) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var listener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<BuildingListItemBinding>(
            inflater,
            R.layout.building_list_item,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.day.text = list[position].building
        holder.binding.task.text = list[position].location
        holder.binding.taskListItem.setOnClickListener{
            (holder.itemView.context as FragmentActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment())
                .addToBackStack(null)
                .commit()
            viewModel.setSelected(item)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder( val binding: BuildingListItemBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            this.binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            listener!!.onClick(v, adapterPosition)
        }
    }
}
