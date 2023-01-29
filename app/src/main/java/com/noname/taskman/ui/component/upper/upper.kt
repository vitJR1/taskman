package com.noname.taskman.ui.component.upper

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.noname.taskman.ui.component.h.H2
import com.noname.taskman.ui.component.inputs.SearchInput

@Composable
fun BodyUpper(title: String, s: MutableState<String>){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
       SearchInput(s.value){ s.value = it }
       H2(title)
    }
}