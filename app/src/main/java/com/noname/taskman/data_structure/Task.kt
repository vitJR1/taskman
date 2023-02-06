package com.noname.taskman.data_structure

import androidx.room.Entity
import androidx.room.PrimaryKey

sealed class TaskStateFilter{
    object ALL: TaskStateFilter()
    object ACTIVE: TaskStateFilter()
    object COMPLETE: TaskStateFilter()
}
@Entity
data class Task(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean
)