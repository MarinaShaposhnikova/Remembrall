package com.meier.marina.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(foreignKeys = [
    ForeignKey(entity = Person::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("personId"),
        onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = Action::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("actionId"),
        onDelete = ForeignKey.CASCADE)])
data class Remembrall(
    val name: String,
    val personId: Long,
    val expirationDate: Date,
    val actionId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
