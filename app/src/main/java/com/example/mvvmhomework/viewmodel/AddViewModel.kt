package com.example.mvvmhomework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmhomework.repository.TaskDaoRepository

class AddViewModel(application: Application) : AndroidViewModel(application) {
    val taskRepository = TaskDaoRepository(application)

    fun add(title: String, description: String) {
        taskRepository.addTask(title, description)
    }
}