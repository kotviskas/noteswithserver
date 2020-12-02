package com.dvach.lab2.pojo

import com.google.gson.annotations.SerializedName

data class TaskForm (
    val title:String,
    val description:String,
    val done:Int,
    val deadline:Long,
    val category_id:Int,
    val priority_id:Int
)