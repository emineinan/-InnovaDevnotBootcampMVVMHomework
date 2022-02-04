package com.example.mvvmhomework.database

import androidx.room.*
import com.example.mvvmhomework.model.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    suspend fun allTasks(): List<Task>

    @Insert
    suspend fun addTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM tasks WHERE title like '%' || :searchedWord || '%'")
    suspend fun searchTask(searchedWord: String): List<Task>
}