@file:Suppress("DEPRECATION")

package edu.adehnerova.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.adehnerova.addnamesavedata.R

import edu.adehnerova.addnamesavedata.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        if (viewModel.getNames() != "") {
            binding.namesView.text = viewModel.getNames()
        }

        binding.addName.setOnClickListener {
            if (binding.nameInput.text.isNotEmpty()) {
                viewModel.setName(binding.nameInput.text.toString())
                binding.namesView.text = viewModel.getNames()
            }
            else {
                binding.namesView.text = getString(R.string.intro)
            }
        }
    }

}