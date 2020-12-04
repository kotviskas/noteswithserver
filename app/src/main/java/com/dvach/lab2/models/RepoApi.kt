package com.dvach.lab2.models
import com.dvach.lab2.pojo.*
import retrofit2.http.*

interface RepoApi {

    @POST("register")
    suspend fun registerUser(@Body form: UserRegistrationForm): User

    @POST("login")
    suspend fun loginUser(@Body form: UserLoginForm): User

    @GET("categories")
    suspend fun getAllCategories(): List<Category>

    @GET("priorities")
    suspend fun getAllPriorities(): List<Priority>

    @GET("tasks")
    suspend fun getAllTasks(): List<Task>

    @POST("tasks")
    suspend fun createTask(@Body form: TaskForm): Task

    @POST("categories")
    suspend fun createCategory(@Body form: CategoryForm): Category

    @PATCH("tasks/{id}")
    suspend fun updateTask(@Path ("id") id: Int, @Body form: TaskForm): Task

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path ("id") id: Int)

}