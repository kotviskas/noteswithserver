package com.dvach.lab2.pojo


import androidx.room.*
import java.io.Serializable


@Entity
data class Task  (

    var title: String,
    var description: String,
    var done: Int,
    var deadline: Long,
    @Embedded
    var category: Category,
    @Embedded
    var priority: Priority,
    val created: Int,

    @PrimaryKey
    val id: Int
): Serializable

@Dao
interface NoteDao {
    @Query("SELECT * FROM Task")
    fun getByName(): Task?

    @Query("SELECT * FROM Task")
    fun getAllTitles(): List<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)
}

