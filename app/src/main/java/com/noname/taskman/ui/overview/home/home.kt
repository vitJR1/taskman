package com.noname.taskman.ui.overview.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.noname.taskman.R
import com.noname.taskman.ui.component.header.Header
import com.noname.taskman.ui.component.upper.BodyUpper
import com.noname.taskman.ui.overview.home.footer.FooterHomeMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){

    val s = remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = { Header() },
        bottomBar = { FooterHomeMenu() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
                .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(10))
                .fillMaxSize()
                .padding(20.dp)
        ) {
            BodyUpper(title = stringResource(id = R.string.Tasks_list), s = s)
        }
    }
}