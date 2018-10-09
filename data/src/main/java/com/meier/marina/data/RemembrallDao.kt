package com.meier.marina.data

import androidx.paging.DataSource
import androidx.room.*
import com.meier.marina.data.entity.Remembrall

@Dao
interface RemembrallDao {

    @Query("SELECT * FROM remembrall")
    fun getAllRemembralls(): DataSource.Factory<Int, Remembrall>

    @Insert
    fun insert(remembrall: Remembrall)

    @Update
    fun update(remembrall: Remembrall)

    @Delete
    fun delete(remembrall: Remembrall)
}
