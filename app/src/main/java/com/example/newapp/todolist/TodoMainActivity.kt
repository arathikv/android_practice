package com.example.newapp.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R
import com.example.newapp.example.recyclerViewData

class TodoMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_main)

        val todoRecyclerView = findViewById<RecyclerView>(R.id.todoRecyclerView)
        todoRecyclerView.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ToDoDataClass>()


        for (i in 1..20) {
            data.add((ToDoDataClass("ToDo")))
        }

        val adapter = ToDoAdapter(data)

        todoRecyclerView.adapter = adapter



    }
}