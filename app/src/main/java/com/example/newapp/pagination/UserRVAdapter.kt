package com.example.newapp.pagination

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
//
//
//class UserRVAdapter    // creating a constructor.
//    (// variable for our array list and context.
//    private val userModalArrayList: ArrayList<UserModal>) :
//    RecyclerView.Adapter<UserRVAdapter.ViewHolder>() {
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // inflating our layout file on below line.
////        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.user_rv_item,parent,false)
////        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        // getting data from our array list in our modal class.
//        val userModal = userModalArrayList[position]
//
//        // on below line we are setting data to our text view.
//        holder.firstNameTV.text = userModal.first_name
//        holder.lastNameTV.text = userModal.last_name
//        holder.emailTV.text = userModal.email
//
//        // on below line we are loading our image
//        // from url in our image view using picasso.
//        Picasso.get().load(userModal.avatar).into(holder.userIV)
//    }
//
//    override fun getItemCount(): Int {
//        // returning the size of array list.
//        return userModalArrayList.size
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        // creating a variable for our text view and image view.
//
//
//            // initializing our variables.
//            val firstNameTV :TextView = itemView.findViewById(R.id.idTVFirstName)
//            val lastNameTV : TextView= itemView.findViewById(R.id.idTVLastName)
//           val emailTV :TextView= itemView.findViewById(R.id.idTVEmail)
//          val  userIV :ImageView= itemView.findViewById(R.id.idIVUser)
//
//    }
//}
