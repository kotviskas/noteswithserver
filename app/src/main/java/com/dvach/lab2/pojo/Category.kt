package com.dvach.lab2.pojo


import androidx.room.*
import com.google.gson.annotations.SerializedName


@Entity
data class Category (

    @SerializedName("name")
    var nameCategory: String,
    @PrimaryKey
    @SerializedName("id")
    val idCategory: Int
)

@Dao
interface CategoryDao {
    @Query("SELECT * FROM Category WHERE nameCategory = :name")
    fun getByName(name: String): Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category?)

    @Query("SELECT * FROM Category")
    fun getAllNames(): List<Category>

    @Query("DELETE FROM Category")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: ArrayList<Category>)
    @Delete
    fun delete(category: Category)
}
