package edu.adehnerova.lifecycleawareness.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import edu.adehnerova.lifecycleawareness.databinding.MainFragmentBinding
import edu.adehnerova.lifecycleawareness.DemoObserver

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    // @ data binding example
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @Suppress("DEPRECATION")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //adding instance of the observer class maintained by lifecycle object
        lifecycle.addObserver(DemoObserver())
        // @ saved state example
        // lambda function which takes current value and converts it to string and displays in textview object
        val resultObserver = Observer<String> { result ->
            binding.message.text = result
        }
        // @ jetpack liveData tutorial
        viewModel.getMsg().observe(viewLifecycleOwner, resultObserver)
    }

}