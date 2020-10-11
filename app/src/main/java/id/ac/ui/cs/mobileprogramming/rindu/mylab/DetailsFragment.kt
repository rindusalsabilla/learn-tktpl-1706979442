package id.ac.ui.cs.mobileprogramming.rindu.mylab

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.rindu.mylab.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var binding: FragmentDetailsBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        viewModel.selected.observe(viewLifecycleOwner, Observer { item ->
            binding!!.day.text = item.day
            binding!!.task.text = item.task
            binding!!.details.text = item.details
        })
    }
}
