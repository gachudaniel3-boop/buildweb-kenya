package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandBlueLight
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900

@Composable
fun TrustStrip(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(Slate100)
      .padding(horizontal = 16.dp, vertical = 20.dp)
  ) {
    // 2x2 Grid for mobile screens
    Column(
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      BuildWebData.trustItems.chunked(2).forEach { rowItems ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          rowItems.forEach { item ->
            Card(
              modifier = Modifier.weight(1f),
              colors = CardDefaults.cardColors(containerColor = PureWhite),
              border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
              shape = RoundedCornerShape(10.dp)
            ) {
              Column(modifier = Modifier.padding(14.dp)) {
                Box(
                  modifier = Modifier
                    .size(36.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(BrandBlueLight),
                  contentAlignment = Alignment.Center
                ) {
                  Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = BrandBlue,
                    modifier = Modifier.size(20.dp)
                  )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                  text = item.title,
                  style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = BrandNavy
                  )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                  text = item.subtitle,
                  style = MaterialTheme.typography.bodySmall.copy(
                    color = Slate700,
                    lineHeight = 16.sp
                  )
                )
              }
            }
          }
        }
      }
    }
  }
}
