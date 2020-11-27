package com.dvach.lab2.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Priority(
    @PrimaryKey
    @SerializedName("id")
    val idPriority: Int,
    @SerializedName("name")
    val namePriority: String,
    val color: String
)