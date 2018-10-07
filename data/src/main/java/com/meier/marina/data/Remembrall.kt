package com.meier.marina.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Remembrall(
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
