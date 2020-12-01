package com.dvach.lab2.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Priority(
    @PrimaryKey
    @SerializedName("id")
    val idPriority: Int,
    @SerializedName("name")
    var namePriority: String,
    val color: String
)