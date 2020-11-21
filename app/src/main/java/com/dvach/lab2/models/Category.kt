package com.dvach.lab2.models


import androidx.room.*


@Entity
data class Category (

    val name: String,
    @PrimaryKey
    val id: Int
)

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category WHERE name = :name")
    fun getByName(name: String): Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category?)

    @Query("SELECT name FROM Category")
    fun getAllNames(): List<String>

    @Transaction
    @Query("SELECT * FROM Category")
    fun getCategoriesWithNotes(): List<CategoryWithNotes>

    @Delete
    fun delete(category: Category)
}
