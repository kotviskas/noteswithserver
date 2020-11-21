package com.dvach.lab2.models

data class TaskForm (
    val tittle:String, val description:String, val done:Int, val deadline:Int, val category_id:Int, val priority_id:Int
)