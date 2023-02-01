package com.noname.taskman.ui.overview.home.body

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R

@Composable
fun TaskCard(task: Int){
    val isCompleted = remember {
            mutableStateOf(task % 2 == 0)
        }
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(35))
            .fillMaxWidth()
            .clickable { isCompleted.value = !isCompleted.value },
        colors = CardDefaults.cardColors(
            containerColor =
                if (isCompleted.value)
                    MaterialTheme.colorScheme.primaryContainer
                else
                    MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(25.dp , 20.dp)
        ) {
            Icon(
                painter =
                if(isCompleted.value)
                    painterResource(id = R.drawable.round_with_round_ico)
                else
                    painterResource(id = R.drawable.round_ico),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            ) 
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Task $task kjhj jkkjbkjj kj kj kj ",
                fontSize = 22.sp,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun TaskList(){
    LazyColumn(
        Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(15){
            TaskCard(it)
        }
    }
}

//подробнее
//возможность автоматически ставить обновить задачу
// (поставить как нувею каждый день)
// профиль
// возможность авторизоватся
// добавить друзей
// донат( по желанию ) я тоже хочу деняг
// пока все идеи