package edu.adehnerova.contactproject.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.adehnerova.contactproject.Contact
import edu.adehnerova.contactproject.R

class ContactListAdapter(private val contactItemLayout: Int) :
    RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    private var contactList: List<Contact>? = null
    var listener: onItemClickListener? = null

    interface onItemClickListener {
        fun onClick(str: String)
    }

    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            contactItemLayout, parent, false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val itemName = holder.name
        val itemPhone = holder.phone
        val itemId = holder.itemId
        var deleteBtn = holder.deleteBtn

        contactList.let {
            itemName.text = it!![listPosition].contactName
            itemPhone.text = it!![listPosition].phoneNumber
            itemId.text = it!![listPosition].contactId.toString()
        }
        deleteBtn.setOnClickListener(View.OnClickListener {
            var id = itemId.text.toString()
            listener?.onClick(id)
        })
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTextView)
        var phone: TextView = itemView.findViewById(R.id.phoneTextView)
        var itemId: TextView = itemView.findViewById(R.id.itemId)
        var deleteBtn: ImageButton = itemView.findViewById(R.id.deleteBtn)
    }

    fun setContactList(contacts: List<Contact>) {
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList.isNullOrEmpty()) 0 else contactList!!.size
    }

}