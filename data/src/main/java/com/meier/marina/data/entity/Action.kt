package com.meier.marina.data.entity

import androidx.annotation.IntDef
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = SocialApp::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("appId"),
    onDelete = ForeignKey.CASCADE)])
data class Action(
    @ActionType val type: Int,
    val appId: Long
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

const val CALL = 0
const val TEXT = 1

@IntDef(CALL, TEXT)
@Retention(AnnotationRetention.RUNTIME)
annotation class ActionType