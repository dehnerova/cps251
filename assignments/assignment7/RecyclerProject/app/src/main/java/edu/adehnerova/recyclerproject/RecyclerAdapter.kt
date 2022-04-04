package edu.adehnerova.recyclerproject

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var viewModel = MainViewModel

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.itemImage)
        var itemTitle: TextView = itemView.findViewById(R.id.itemTitle)
        var itemDetail: TextView = itemView.findViewById(R.id.itemDetail)

        init {

            itemView.setOnClickListener { v: View ->

                val position: Int = getAdapterPosition()
                Snackbar.make(
                    v, "Click detected on item $position",
                    Snackbar.LENGTH_LONG
                ).setAction("Action", null).show()
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = viewModel.getTitles()[i]
        viewHolder.itemDetail.text = viewModel.getDetails()[i]
        viewHolder.itemImage.setImageResource(viewModel.getImages()[i])
    }

    override fun getItemCount(): Int {
        return viewModel.getTitles().size
    }

}
