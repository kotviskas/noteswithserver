package com.dvach.lab2.models

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithNotes(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryName",
        entityColumn = "category"
    )
    val tasks: List<Task>


)

