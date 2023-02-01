package com.noname.taskman.ui.component.inputs

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R
import com.noname.taskman.ui.theme.Black30
import kotlinx.coroutines.launch

@Composable
fun SearchInput(
    value: String,
    onValueChange:(String)->Unit
){

    val isFocused = remember {
        mutableStateOf(false)
    }

    val logState = rememberScrollState(0)
    val coroutine = rememberCoroutineScope()

    LaunchedEffect(coroutine) {
        logState.scrollTo(logState.maxValue)
    }

    BasicTextField(
        value = value,
        onValueChange = {
            onValueChange(it);
            coroutine.launch {
                logState.scrollTo(logState.maxValue)
            }
        },
        modifier = Modifier
            .width(200.dp)
            .onFocusChanged { isFocused.value = it.isFocused },
        singleLine = true,
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search_ico),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = if(value.isNotEmpty() || isFocused.value) value
                            else stringResource(id = R.string.Search),
                fontSize = 16.sp,
                softWrap = false,
                modifier = Modifier.horizontalScroll(logState),
            )

        }
    }
}