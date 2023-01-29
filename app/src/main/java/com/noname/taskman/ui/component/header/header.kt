package com.noname.taskman.ui.component.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.noname.taskman.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(){
    Row(
        modifier = Modifier
            .padding(10.dp)
            .background(MaterialTheme.colorScheme.surface, RoundedCornerShape(50))
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(10.dp))
            Box(modifier = Modifier
                .padding(5.dp)
                .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(25))
                .padding(8.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.box_ico),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp)
                )
            }
            Text(
                text = stringResource(id = R.string.Taskman),
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.bell_ico),
                contentDescription = "",
                modifier = Modifier.size(25.dp)
            )
            
            Spacer(modifier = Modifier.width(10.dp))
            
            Box(
                modifier = Modifier
                    .padding(3.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(50))
                    .padding(9.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    painter = painterResource(id = R.drawable.profile_ico),
                    contentDescription = "",
                    modifier = Modifier.size(22.dp)
                )
            }
        }
    }
}