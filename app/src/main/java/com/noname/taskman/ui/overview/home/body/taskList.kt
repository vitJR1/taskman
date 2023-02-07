package com.noname.taskman.ui.overview.home.body

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R
import com.noname.taskman.data_structure.Task
import com.noname.taskman.data_structure.TaskStateFilter

@Composable
fun TaskCard(task: Task, onClick: (Int) -> Unit){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(35))
            .fillMaxWidth()
            .clickable { onClick(task.id) },
        colors = CardDefaults.cardColors(
            containerColor =
                if (task.isCompleted)
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
                if(task.isCompleted)
                    painterResource(id = R.drawable.round_with_round_ico)
                else
                    painterResource(id = R.drawable.round_ico),
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            ) 
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = task.title,
                fontSize = 22.sp,
                softWrap = false,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun TaskList(
    tasks: List<Task>,
//    search: String,
//    completeTaskFilters: TaskStateFilter = TaskStateFilter.ALL,
    onClick: (Int)->Unit,
){
    LazyColumn(
        Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items(
            tasks
        ){ task ->
            TaskCard(task, onClick)
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