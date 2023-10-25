package com.example.newapp.localpagination

import androidx.hilt.lifecycle.ViewModelInject
import androidx.paging.ExperimentalPagingApi


@ExperimentalPagingApi
class NetworkOnlyViewModel @ViewModelInject constructor(private val repository: CatsRepository) :
    BaseViewModel() {
     val dataSource = repository.getCatsFromNetwork()
}