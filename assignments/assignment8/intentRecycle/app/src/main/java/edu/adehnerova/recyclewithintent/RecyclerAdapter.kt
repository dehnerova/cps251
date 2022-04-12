package edu.adehnerova.recyclewithintent

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var viewModel = MainViewModel
    var data = Data.newInstance()


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text = data.titles[viewModel.intArray[i][0]]
        viewHolder.itemDetail.text = data.details[viewModel.intArray[i][1]]
        viewHolder.itemImage.setImageResource(data.images[viewModel.intArray[i][2]])
        Log.d("DETAIL", "setting details ${viewHolder.itemDetail.text}")
    }

    override fun getItemCount(): Int {
        return data.titles.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView
        var itemDetail: TextView
        var itemImage: ImageView


        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle= itemView.findViewById(R.id.itemTitle)
            itemDetail= itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener { v: View ->

                var position: Int = adapterPosition

                var title = viewModel.intArray[position][0]
                var detail = viewModel.intArray[position][1]
                var image = viewModel.intArray[position][2]

                Log.d("HOLDER", "in clickListener $detail")

                val i = Intent(v.context, SecondActivity::class.java)

                i.putExtra("title", title)
                i.putExtra("details", detail)
                i.putExtra("image", image)

                Log.d("EXTRA", "in putExtra $detail")

                startActivity(v.context,i,null)
            }
        }
    }

}