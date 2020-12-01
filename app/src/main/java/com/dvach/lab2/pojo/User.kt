package com.dvach.lab2.pojo

import androidx.room.*
import java.io.Serializable


@Entity
data class User  (
    var name: String,
    var email: String,
    var api_token:String,

    @PrimaryKey

    var userId: Int
) : Serializable

@Dao
interface UserDao {
    @Query("SELECT * FROM User WHERE userId = :id")
    fun getById(id: Long): User?

    @Insert
    fun insert(user: User?)

    @Query("SELECT * FROM User WHERE email=:email")
    fun getUser(email: String): User

    @Query("SELECT * FROM User WHERE email=:email")
    fun getUserByEmail(email: String): User?
}

