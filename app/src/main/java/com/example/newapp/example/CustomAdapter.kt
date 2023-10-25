package com.example.newapp.example

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R

class CustomAdapter(private val itemList:List<recyclerViewData>):RecyclerView.Adapter<CustomAdapter.viewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design,parent,false)

        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int){
        val recyclerViewData = itemList[position]
        holder.imageView.setImageResource(recyclerViewData.image)
        holder.textView.text=recyclerViewData.text
    }

    class viewHolder(ItemView: View): RecyclerView.ViewHolder (ItemView) {
        val imageView : ImageView = itemView.findViewById(R.id.recyclerViewImage)
        val textView : TextView =itemView.findViewById(R.id.recyclerViewText)

    }
}