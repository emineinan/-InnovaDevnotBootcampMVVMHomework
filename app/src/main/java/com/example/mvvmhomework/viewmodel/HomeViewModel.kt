package com.example.mvvmhomework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvmhomework.model.Task
import com.example.mvvmhomework.repository.TaskDaoRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var taskList = MutableLiveData<List<Task>>()
    val taskRepository = TaskDaoRepository(application)

    init {
        allTasks()
        taskList = taskRepository.getAllTasks()
    }

    fun delete(id: Int) {
        taskRepository.deleteTask(id)
    }

    fun search(searchedWord: String) {
        taskRepository.searchTask(searchedWord)
    }

    fun allTasks() {
        taskRepository.allTasks()
    }
}