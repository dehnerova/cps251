package com.example.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationproject.R
import com.example.navigationproject.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.button1.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment()

            //setting photo description as the text value above the image
            action.textView = binding.imageView1.contentDescription.toString()
            //setting appropriate image
            action.displayImage = R.drawable.android_image_1
            Navigation.findNavController(it).navigate(action)

        }

        binding.button2.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment()

            //setting photo description as the text value above the image
            action.textView = binding.imageView2.contentDescription.toString()
            //setting appropriate image
            action.displayImage = R.drawable.android_image_2
            Navigation.findNavController(it).navigate(action)

        }
        binding.button3.setOnClickListener {
            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment =
                MainFragmentDirections.actionMainFragmentToSecondFragment()

            //setting photo description as the text value above the image
            action.textView = binding.imageView3.contentDescription.toString()
            //setting appropriate image
            action.displayImage = R.drawable.android_image_3
            Navigation.findNavController(it).navigate(action)

        }

    }

}