package com.noname.taskman.ui.overview.home.body

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R

@Composable
fun TaskCard(task: Int){
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(35))
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(25.dp, 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_ico), 
                contentDescription = "",
                modifier = Modifier.size(20.dp)
            ) 
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Task $task",
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun TaskList(){
    LazyColumn(
        Modifier.padding(top = 20.dp).clip(RoundedCornerShape(8.dp)),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(15){
            TaskCard(it)
        }
    }
}