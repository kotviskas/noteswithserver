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
    var created: Int,

    @PrimaryKey(autoGenerate = true)
    var id: Int
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

    @Query("DELETE FROM Task")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: ArrayList<Task>)
}

