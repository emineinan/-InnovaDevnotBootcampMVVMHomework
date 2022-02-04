package com.example.mvvmhomework.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.mvvmhomework.database.TaskDatabase
import com.example.mvvmhomework.model.Task
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDaoRepository(var application: Application) {
    var taskList: MutableLiveData<List<Task>> = MutableLiveData()
    var taskDatabase: TaskDatabase = TaskDatabase.getDatabase(application)!!

    fun getAllTasks(): MutableLiveData<List<Task>> {
        return taskList
    }

    fun addTask(title: String, description: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val newTask = Task(0, title, description)
            taskDatabase.taskDao().addTask(newTask)
        }
    }

    fun updateTask(id: Int, title: String, description: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val updatedTask = Task(id, title, description)
            taskDatabase.taskDao().updateTask(updatedTask)
        }
    }

    fun deleteTask(id: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val deletedTask = Task(id, "", "")
            taskDatabase.taskDao().deleteTask(deletedTask)
            allTasks()
        }
    }

    fun searchTask(searchedWord: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskDatabase.taskDao().searchTask(searchedWord)
        }
    }

    fun allTasks() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            taskList.value = taskDatabase.taskDao().allTasks()
        }
    }
}