package com.meier.marina.listremembrall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.meier.marina.base.ScopedViewModel
import com.meier.marina.base.State
import com.meier.marina.data.entity.Remembrall
import com.meier.marina.data.RemembrallDao

internal class RemembrallListViewModel(remembrallDao: RemembrallDao) : ScopedViewModel() {

    val stateLV = MutableLiveData<State>()

    val data: LiveData<PagedList<Remembrall>>

    init {

        stateLV.value = State.Loading

        val boundaryCallback = object : PagedList.BoundaryCallback<Remembrall>() {
            override fun onZeroItemsLoaded() {
                super.onZeroItemsLoaded()
                stateLV.value = State.Error(R.string.no_remembrall)
            }

            override fun onItemAtEndLoaded(itemAtEnd: Remembrall) {
                super.onItemAtEndLoaded(itemAtEnd)
                stateLV.value = State.Success
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
}
