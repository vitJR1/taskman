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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.noname.taskman.R
import com.noname.taskman.data_structure.Task
import com.noname.taskman.model.HomeScreenModel
import com.noname.taskman.ui.component.header.Header
import com.noname.taskman.ui.component.upper.BodyUpper
import com.noname.taskman.ui.overview.home.body.TaskList
import com.noname.taskman.ui.overview.home.footer.FooterHomeMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val vm by remember { mutableStateOf(HomeScreenModel()) }

    val fState = vm.filter.collectAsState()

    Scaffold(
        topBar = { Header() },
        bottomBar = { FooterHomeMenu(fState, vm) }
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
            TaskList(
                listOf(
                    Task(1, "wake up", "", true),
                    Task(2, "go to job", "", false),
                    Task(3, "go to home", "", false),
                    Task(4, "watch a film", "", false),
                    Task(5, "do something", "", true),
                    Task(6, "go to shopping", "", false),
                    Task(7, "buy a new cool item", "", true),
                    Task(8, "go to job", "", false),
                    Task(9, "forget that song", "", true),
                    Task(10, "update myself", "", false),
                ),
                vm.search.value,
                fState.value
            )
        }
    }
}