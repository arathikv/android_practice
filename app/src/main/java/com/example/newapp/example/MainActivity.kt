package com.example.newapp.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<recyclerViewData>()

        for (i in 1..20){
            data.add(recyclerViewData(R.drawable.ic_launcher_background,"Item"+i))
        }

        val adapter= CustomAdapter(data)

        recyclerView.adapter=adapter

    }
}