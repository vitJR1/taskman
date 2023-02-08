package com.noname.taskman.ui.overview.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.noname.taskman.R
import com.noname.taskman.data_structure.LocalStates
import com.noname.taskman.data_structure.Task
import com.noname.taskman.data_structure.TaskStateFilter
import com.noname.taskman.model.HomeScreenModel
import com.noname.taskman.ui.component.header.Header
import com.noname.taskman.ui.component.preloader.TaskListPreloader
import com.noname.taskman.ui.component.upper.BodyUpper
import com.noname.taskman.ui.overview.home.body.EmptyTaskListScreen
import com.noname.taskman.ui.overview.home.body.ErrorScreen
import com.noname.taskman.ui.overview.home.body.TaskList
import com.noname.taskman.ui.overview.home.footer.FooterHomeMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val context = LocalContext.current

    val vm by remember { mutableStateOf(HomeScreenModel(context)) }

    val tlState = vm.tlState.collectAsState()
    val fState = vm.filter.collectAsState()

    Scaffold(
        topBar = { Header() },
        bottomBar = { FooterHomeMenu(fState){vm.setFilter(it)} }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(10))
                .fillMaxSize()
                .padding(20.dp)
        ) {
            BodyUpper(title = stringResource(id = R.string.Tasks_list), s = vm.search)

            when(tlState.value) {
                LocalStates.START->{
                    TaskListPreloader()
                }
                LocalStates.LOADING->{
                    TaskListPreloader()
                }
                LocalStates.SUCCESS->{
                    TaskList(
                        vm.taskList.filter {
                            it.title.lowercase().contains(vm.search.value)
                                    && when(fState.value){
                                        TaskStateFilter.ALL-> true
                                        TaskStateFilter.ACTIVE-> ! it.isCompleted
                                        TaskStateFilter.COMPLETE-> it.isCompleted
                            }
                        }
                    ) {
                        vm.toggleTaskState(it)
                    }
                }
                LocalStates.FAILURE->{
                    ErrorScreen(stringResource(id = R.string.Update_is_failed))
                }
            }
        }
    }
}