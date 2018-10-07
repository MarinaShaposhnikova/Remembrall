package com.meier.marina.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Remembrall::class], version = 1)
abstract class Database : RoomDatabase() {

    abstract fun remembrallDAO(): RemembrallDao
}
