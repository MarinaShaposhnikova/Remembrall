package com.meier.marina.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SocialApp(
    val name: String,
    val appId: String,
    val iconRes: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
