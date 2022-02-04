package com.example.mvvmhomework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvmhomework.repository.TaskDaoRepository

class UpdateViewModel(application: Application) : AndroidViewModel(application) {
    val taskRepository = TaskDaoRepository(application)

    fun update(id: Int, title: String, description: String) {
        taskRepository.updateTask(id, title, description)
    }
}