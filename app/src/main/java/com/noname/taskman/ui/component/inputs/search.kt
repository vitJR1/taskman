package com.noname.taskman.ui.component.inputs

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R

@Composable
fun SearchInput(
    value: String,
    onValueChange:(String)->Unit
){
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.width(200.dp),
        singleLine = true,
        textStyle = TextStyle.Default.copy(color = Color.Black)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search_ico),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            )
            if(value.isEmpty()) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = stringResource(id = R.string.Search),
                    fontSize = 16.sp,
                    softWrap = false
                )
            }
        }
    }
}