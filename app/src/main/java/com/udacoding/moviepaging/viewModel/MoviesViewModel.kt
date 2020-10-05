package com.udacoding.moviepaging.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.udacoding.moviepaging.dataSource.factory.MoviesDataFactory
import com.udacoding.moviepaging.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MoviesViewModel : ViewModel() {

    var executor: Executor
    var reslutData: LiveData<PagedList<ResultsItem>>

    init {
        executor = Executors.newFixedThreadPool(5)

        var moviesFactory = MoviesDataFactory()

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        reslutData = LivePagedListBuilder(moviesFactory, pageListConfig)
            .setFetchExecutor(executor)
            .build()
    }

    fun getResult(): LiveData<PagedList<ResultsItem>> {
        return reslutData
    }
}