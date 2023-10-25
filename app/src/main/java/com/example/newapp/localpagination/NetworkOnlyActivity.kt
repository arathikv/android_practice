//package com.example.newapp.localpagination
//
//import android.os.Bundle
//
//import androidx.lifecycle.lifecycleScope
//import androidx.paging.ExperimentalPagingApi
//
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//
//@ExperimentalPagingApi
//@AndroidEntryPoint
//class NetworkOnlyActivity : BaseCatActivity() {
//
//    override val viewModel: NetworkOnlyViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityCatsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        initAdapter()
//        lifecycleScope.launch {
//            viewModel.cats.collectLatest {
//                adapter.submitData(it)
//            }
//        }
//    }
//}