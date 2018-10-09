package com.meier.marina.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meier.marina.data.entity.Action
import com.meier.marina.data.entity.Person
import com.meier.marina.data.entity.Remembrall
import com.meier.marina.data.entity.SocialApp

@Database(entities = [Remembrall::class, Person::class, Action::class, SocialApp::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {

    abstract fun remembrallDAO(): RemembrallDao
}
