package com.udacoding.moviepaging.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.udacoding.moviepaging.dataSource.MoviesDataSource
import com.udacoding.moviepaging.model.ResultsItem

class MoviesDataFactory : DataSource.Factory<Long, ResultsItem>() {


    var mutableLiveData : MutableLiveData<MoviesDataSource>
    var moviesDataSource : MoviesDataSource

    init {
        mutableLiveData = MutableLiveData()
        moviesDataSource = MoviesDataSource()
    }

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLiveData.postValue(moviesDataSource)
        return moviesDataSource
    }

    @JvmName("getMutableLiveData1")
    fun getMutableLiveData(): MutableLiveData<MoviesDataSource>{
        return mutableLiveData
    }

}