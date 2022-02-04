package com.example.mvvmhomework.database

import android.content.Context
import androidx.room.*
import com.example.mvvmhomework.model.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        var INSTANCE: TaskDatabase? = null

        fun getDatabase(context: Context): TaskDatabase? {
            if (INSTANCE == null) {
                synchronized(TaskDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "tasks.sqlite"
                    ).createFromAsset("tasks.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}