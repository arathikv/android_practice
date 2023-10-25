package com.example.newapp.localpagination
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
//import com.c_od_e.pagination.db.CatDatabase
//import com.c_od_e.pagination.model.Cat
//import com.c_od_e.pagination.network.CatApi
//import com.c_od_e.pagination.network.CatPagingSource
//import com.c_od_e.pagination.network.CatRemoteMediator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 30

class CatsRepository @Inject constructor(
    private val catApi: CatApi,

) {
    @ExperimentalPagingApi
    fun getCatsFromNetwork(): Flow<PagingData<Cat>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                maxSize = PAGE_SIZE + (PAGE_SIZE * 2),
                enablePlaceholders = false
            ),
            pagingSourceFactory = { CatPagingSource(catApi) }
        ).flow
    }





}