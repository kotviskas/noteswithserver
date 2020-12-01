package com.dvach.lab2.pojo

data class TaskForm (
    val tittle:String, val description:String, val done:Int, val deadline:Long, val category_id:Int, val priority_id:Int
)