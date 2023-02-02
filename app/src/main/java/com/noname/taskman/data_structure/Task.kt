package com.noname.taskman.data_structure

sealed class TaskStateFilter{
    object ALL: TaskStateFilter()
    object ACTIVE: TaskStateFilter()
    object COMPLETE: TaskStateFilter()
}

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean
)