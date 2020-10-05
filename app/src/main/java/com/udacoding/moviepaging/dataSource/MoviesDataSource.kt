package com.udacoding.moviepaging.dataSource

import androidx.paging.PageKeyedDataSource
import com.udacoding.moviepaging.model.ResultsItem
import com.udacoding.moviepaging.network.MoviesService
import com.udacoding.moviepaging.network.ServiceApi
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MoviesDataSource : PageKeyedDataSource<Long, ResultsItem>() {

    var api: MoviesService

    init {
        api = ServiceApi.serviceApi()
    }

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {
        api.getData(
            "b64d761def5c00e40e6a36e0032741bf",
            "language=en-US",
            1,
            params.requestedLoadSize
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                t.results?.let { callback.onResult(it, null, 2L) }

            }, {

            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getData(
            "b64d761def5c00e40e6a36e0032741bf",
            "language=en-US",
            params.key,
            params.requestedLoadSize
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                t.results?.let { callback.onResult(it, params.key + 1) }

            }, {

            })

    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
    }
}