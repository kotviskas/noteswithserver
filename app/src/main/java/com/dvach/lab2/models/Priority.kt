package com.dvach.lab2.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Priority(
    @PrimaryKey
    val id: Int,
    val name: String, val color: String
)