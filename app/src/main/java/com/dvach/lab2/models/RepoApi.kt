package com.dvach.lab2.models
import com.dvach.lab2.pojo.*
import retrofit2.http.*

interface RepoApi {

    @POST("register")
    suspend fun registerUser(@Body form: UserRegistrationForm): User

    @POST("login")
    suspend fun loginUser(@Body form: UserLoginForm): User

    @GET("categories")
    suspend fun getAllCategories(@Header("Authorization") token: String): List<Category>

    @GET("priorities")
    suspend fun getAllPriorities(@Header("Authorization") token: String): List<Priority>

    @GET("tasks")
    suspend fun getAllTasks(@Header("Authorization") token: String): List<Task>

    @POST("tasks")
    suspend fun createTask(@Header("Authorization") token: String, @Body form: TaskForm): Task

    @POST("categories")
    suspend fun createCategory(@Header("Authorization") token: String, @Body form: CategoryForm): Category

    @PATCH("task/{id}")
    suspend fun updateTask(@Header("Authorization") token:String, @Path ("id") id: Int, @Body form: TaskForm): Task

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Header("Authorization") token: String,@Path ("id") id: Int)

}