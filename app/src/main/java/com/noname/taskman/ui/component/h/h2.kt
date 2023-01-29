package com.noname.taskman.ui.component.h

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight.Companion.W600
import androidx.compose.ui.unit.sp

@Composable
fun H2(text: String){
    Text(
        text = text,
        fontSize = 20.sp,
        fontWeight = W600
    )
}