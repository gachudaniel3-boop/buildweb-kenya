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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
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
import com.example.ui.theme.WhatsAppGreen

@Composable
fun WhyUsAndProcessSection(
  onBuildMyWebsite: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(PureWhite)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    // WHY CHOOSE US
    Text(
      text = "WHY BUILDWEB KENYA",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "Why Businesses Choose BuildWeb Kenya",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(20.dp))

    // 6 Feature Cards (Grid-like)
    Column(
      verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
      BuildWebData.whyChooseUs.forEach { item ->
        Card(
          colors = CardDefaults.cardColors(containerColor = PureWhite),
          border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
          ) {
            Box(
              modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(BrandBlueLight),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = BrandBlue,
                modifier = Modifier.size(22.dp)
              )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
              Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold,
                  color = BrandNavy
                )
              )

              Spacer(modifier = Modifier.height(4.dp))

              Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                  color = Slate700,
                  lineHeight = 20.sp
                )
              )
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(40.dp))

    // HOW IT WORKS
    Text(
      text = "OUR PROCESS",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "How It Works",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "From idea to live website in 5 simple, risk-free steps.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Vertical Timeline Process
    Column(
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      BuildWebData.howItWorks.forEach { step ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          verticalAlignment = Alignment.Top
        ) {
          Box(
            modifier = Modifier
              .size(38.dp)
              .clip(CircleShape)
              .background(BrandNavy),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = step.stepNumber,
              fontSize = 13.sp,
              fontWeight = FontWeight.Bold,
              color = PureWhite
            )
          }

          Spacer(modifier = Modifier.width(14.dp))

          Card(
            colors = CardDefaults.cardColors(containerColor = Slate100),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.weight(1f)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = step.title,
                style = MaterialTheme.typography.titleSmall.copy(
                  fontWeight = FontWeight.Bold,
                  color = BrandNavy
                )
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = step.description,
                style = MaterialTheme.typography.bodyMedium.copy(
                  color = Slate700
                )
              )
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // CTA: Build My Website
    Button(
      onClick = onBuildMyWebsite,
      colors = ButtonDefaults.buttonColors(
        containerColor = BrandBlue,
        contentColor = PureWhite
      ),
      shape = RoundedCornerShape(10.dp),
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .testTag("process_cta_build_my_website")
    ) {
      Icon(
        imageVector = Icons.Default.Chat,
        contentDescription = "WhatsApp",
        tint = WhatsAppGreen,
        modifier = Modifier.size(20.dp)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
        text = "Build My Website",
        style = MaterialTheme.typography.titleMedium.copy(
          fontWeight = FontWeight.Bold
        )
      )
    }
  }
}
