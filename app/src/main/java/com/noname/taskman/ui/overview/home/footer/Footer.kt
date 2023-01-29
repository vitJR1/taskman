package com.noname.taskman.ui.overview.home.footer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.noname.taskman.R
import com.noname.taskman.ui.theme.White90

@Composable
fun FooterHomeMenu(){
    val textSize = 16.sp

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.primaryContainer,
                RoundedCornerShape(20)
            )
            .height(60.dp)
    ) {
        Spacer(modifier = Modifier.width(1.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.endless_ico),
                contentDescription = "",
                tint = White90,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = stringResource(id = R.string.All),
                color = White90,
                fontSize = textSize
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.background
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_with_checkmark_ico),
                contentDescription = "",
                tint = White90,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = stringResource(id = R.string.Done),
                color = White90,
                fontSize = textSize
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .padding(vertical = 8.dp),
            color = MaterialTheme.colorScheme.background
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_with_cross_ico),
                contentDescription = "",
                tint = White90,
                modifier = Modifier.size(25.dp)
            )
            Text(
                text = stringResource(id = R.string.Unfin),
                color = White90,
                fontSize = textSize
            )
        }
        Spacer(modifier = Modifier.width(1.dp))
    }
}