package com.noname.taskman.data_structure

import kotlinx.coroutines.flow.MutableStateFlow


sealed class LocalStates(){
    object START: LocalStates()
    object LOADING: LocalStates()
    object SUCCESS: LocalStates()
    object FAILURE: LocalStates()
}
