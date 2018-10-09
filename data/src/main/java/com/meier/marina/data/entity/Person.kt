package com.meier.marina.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(val name: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
