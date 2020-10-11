package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.rindu.mylab.databinding.FragmentTaskListBinding

import java.util.ArrayList

class TaskListFragment : Fragment() {
    private var binding: FragmentTaskListBinding? = null
    private val detailsFragment = DetailsFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_list, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        val list = ArrayList<Item>()
        list.add(
            Item(
                "Monday",
                "Debugging",
                "Learn about different types of errors in Java and practice finding them"
            )
        )
        list.add(
            Item(
                "Monday",
                "Design patterns",
                "Learn more about Observer and Adapter patterns"
            )
        )
        list.add(Item("Tuesday", "Algorithms", "Study quick sort algorithm"))

        val adapter = RecyclerViewAdapter(list)
        binding!!.recyclerView.adapter = adapter

    }
}
