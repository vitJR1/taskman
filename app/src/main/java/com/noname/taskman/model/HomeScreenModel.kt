package com.noname.taskman.model

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.noname.taskman.R
import com.noname.taskman.data_structure.LocalStates
import com.noname.taskman.data_structure.Task
import com.noname.taskman.data_structure.TaskStateFilter
import com.noname.taskman.local_storage.AppDatabase
import com.noname.taskman.local_storage.TaskDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.log

class HomeScreenModel(
    val ctx: Context
    ): ViewModel() {

    val search = mutableStateOf("")

    val filter = MutableStateFlow<TaskStateFilter>(TaskStateFilter.ALL)

    var tlState = MutableStateFlow<LocalStates>(LocalStates.START)

    var taskList = mutableStateListOf(
        Task(1, "wake up", "", true),
        Task(2, "go to job", "", false),
        Task(3, "go to home", "", false),
        Task(4, "watch a film", "", false),
        Task(5, "do something", "", true),
        Task(6, "go to shopping", "", false),
        Task(7, "buy a new cool item", "", true),
        Task(8, "go to job", "", false),
        Task(9, "forget that song", "", true),
        Task(10, "update myself", "", false)
    )

    init {
        tlState.value = LocalStates.SUCCESS
//        LoadTasksList(this.ctx);
    }

    fun LoadTasksList(context: Context){
        tlState.value = LocalStates.LOADING

        try {
            val db = Room.databaseBuilder(
                context,
                AppDatabase::class.java, context.getString(R.string.DATABASE_NAME)
            ).build()

            taskList.clear()

            db.taskDao?.getTasks.orEmpty().forEach {
                taskList.add(it as Task)
            }

            tlState.value = LocalStates.SUCCESS

        }catch (e: Exception){
            e.localizedMessage?.let { Log.e("LoadTasksList", it) };
            e.stackTraceToString().let { Log.e("LoadTasksList", it) };
            tlState.value = LocalStates.FAILURE
        }
    }

    // U can make it public if u need
    private fun getTask(id: Int):Task?{
        return taskList.firstOrNull { id == it.id }
    }

    // Yes, and it's also
    private fun getTaskIndex(id: Int):Int{
        return taskList.indexOf(getTask(id))
    }

    fun setFilter(filter: TaskStateFilter){
        this.filter.value = filter
    }

    fun toggleTaskState(id: Int): Boolean{
        val task = getTask(id)
        try {
            if(task != null) {
                taskList[getTaskIndex(id)] = task.copy(isCompleted = !task.isCompleted)
                return true
            }
        }catch (e: Exception){
            e.localizedMessage?.let { Log.e("LoadTasksList", it) }
        }
        return false
    }

}