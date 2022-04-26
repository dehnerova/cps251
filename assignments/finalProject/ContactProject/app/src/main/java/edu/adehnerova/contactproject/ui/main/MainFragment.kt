package edu.adehnerova.contactproject.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import edu.adehnerova.contactproject.Contact
import edu.adehnerova.contactproject.R
import edu.adehnerova.contactproject.databinding.MainFragmentBinding
import java.lang.Integer.parseInt
import android.widget.TextView
import java.util.*

class MainFragment : Fragment() {

    private var contactAdapter: ContactListAdapter? = null
    val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        listenerSetup()
        observerSetup()
        recyclerSetup()

        return binding.root
    }

    private fun listenerSetup() {
        binding.addBtn.setOnClickListener {
            //binding name variable to input text
            val name = binding.name.text.toString()
            //binding phone variable to input text
            val phone = binding.phone.text.toString()

            //if user entered a name and phone...
            if (name.isNotEmpty() && phone.isNotEmpty()) {
                //create a contact object
                val contact = Contact(name, phone)
                //send contact object to DB
                viewModel.insertContact(contact)
                //clear fields for new contact to be added
                clearFields()
            } else {
                binding.name.setHint("Incomplete information")
            }
        }

        binding.findBtn.setOnClickListener {
            viewModel.findContact(binding.name.text.toString())
        }
        binding.ascBtn.setOnClickListener {
            viewModel.ascSort()
        }
        binding.descBtn.setOnClickListener {
            viewModel.descSort()
        }
    }

    private fun clearFields() {
        binding.name.setText("")
        binding.phone.setText("")
    }

    private fun observerSetup() {
        viewModel.getSearchResults()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    contactAdapter?.setContactList(it)
                }
                else {
                    binding.name.setHint("No match")
                }
            }
        })

        viewModel.getAllContacts()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                contactAdapter?.setContactList(it)
            }
        })

        viewModel.ascSort()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                contactAdapter?.setContactList(it)
            }
        })

        viewModel.descSort()?.observe(viewLifecycleOwner, Observer { contacts ->
            contacts?.let {
                contactAdapter?.setContactList(it)
            }
        })
    }

    private fun recyclerSetup() {
        contactAdapter = ContactListAdapter(R.layout.card_layout)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = contactAdapter

        //using hidden id to delete clicked cards
        contactAdapter!!.settingListener(object : ContactListAdapter.onItemClickListener {
            override fun onClick(str: String) {
                val itemId: Int = parseInt(str)
                viewModel.deleteContact(itemId)
            }
        })
    }
}