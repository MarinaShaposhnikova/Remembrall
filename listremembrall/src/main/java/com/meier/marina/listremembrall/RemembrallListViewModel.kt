package com.meier.marina.listremembrall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.meier.marina.data.Remembrall
import com.meier.marina.data.RemembrallDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

//TODO: refactor with Scope
internal class RemembrallListViewModel(private val remembrallDao: RemembrallDao) : ViewModel(), CoroutineScope {
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default

    val stateLV = MutableLiveData<State>()

    val data: LiveData<PagedList<Remembrall>>

    init {

        val boundaryCallback = object : PagedList.BoundaryCallback<Remembrall>() {
            override fun onZeroItemsLoaded() {
                super.onZeroItemsLoaded()
                //TODO: set empty state and remove inserting
                launch {
                    remembrallDao.insert(Remembrall("marina"))
                }

            }

            override fun onItemAtEndLoaded(itemAtEnd: Remembrall) {
                super.onItemAtEndLoaded(itemAtEnd)
                //TODO: set not empty state
            }
        }

        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setPrefetchDistance(30)
            .setEnablePlaceholders(true)
            .build()

        val dataSource: DataSource.Factory<Int, Remembrall> = remembrallDao.getAllRemembralls()

        data = LivePagedListBuilder(dataSource, config)
            .setBoundaryCallback(boundaryCallback)
            .build()
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}

//TODO: make common sealed state
class State