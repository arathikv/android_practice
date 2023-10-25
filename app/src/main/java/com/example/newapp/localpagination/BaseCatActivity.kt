package com.example.newapp.localpagination

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import com.c_od_e.pagination.databinding.ActivityCatsBinding
import com.c_od_e.pagination.view.adapter.CatsAdapter
import com.c_od_e.pagination.view.adapter.CatsLoadStateAdapter

abstract class BaseCatActivity : AppCompatActivity() {
    abstract val viewModel: BaseViewModel
    lateinit var binding: ActivityCatsBinding}