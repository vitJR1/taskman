package com.noname.taskman.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.noname.taskman.data_structure.TaskStateFilter
import kotlinx.coroutines.flow.MutableStateFlow

class HomeScreenModel: ViewModel() {

    val search = mutableStateOf("")
    val filter = MutableStateFlow<TaskStateFilter>(TaskStateFilter.ALL)



}