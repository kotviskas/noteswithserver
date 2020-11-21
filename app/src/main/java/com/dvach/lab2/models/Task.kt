package com.dvach.lab2.models


import androidx.room.*
import com.dvach.lab2.R
import java.io.Serializable


@Entity
data class Task  (

    val title: String,
    val description: String,
    val done: Int,
    val deadline: Int,
    val category: Category,
    val priority: Priority,
    val created: Int,

    @PrimaryKey
    val id: Int
): Serializable

@Dao
interface NoteDao {
    @Query("SELECT * FROM Task")
    fun getByName(): Task?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

}

