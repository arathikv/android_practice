package com.example.newapp.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R

class ToDoAdapter(private val todoList : List<ToDoDataClass>):RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_list_view,parent,false)

        return ToDoViewHolder(view)
    }
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val todoViewItem =todoList[position]
        holder.todoView.text = todoViewItem.item
    }

    override fun getItemCount(): Int {
        return  todoList.size
    }



    class ToDoViewHolder(TodoView:View):RecyclerView.ViewHolder(TodoView) {
        val todoView : TextView = itemView.findViewById(R.id.todoTextView)
    }


}