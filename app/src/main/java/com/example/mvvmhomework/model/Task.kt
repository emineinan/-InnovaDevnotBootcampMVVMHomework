package com.example.mvvmhomework.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @NotNull
    val id: Int,
    @ColumnInfo(name = "title") @NotNull
    val title: String,
    @ColumnInfo(name = "description") @NotNull
    val description: String
) : Serializable
