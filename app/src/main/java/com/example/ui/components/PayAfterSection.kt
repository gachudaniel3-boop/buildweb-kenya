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
import androidx.compose.material.icons.filled.VerifiedUser
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
import com.example.ui.theme.BrandCyan
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate200
import com.example.ui.theme.WhatsAppGreen

@Composable
fun PayAfterSection(
  onStartWebsite: () -> Unit,
  modifier: Modifier = Modifier
) {
  // Contrasting Dark Corporate Navy Background
  Box(
    modifier = modifier
      .fillMaxWidth()
      .background(BrandNavy)
      .padding(horizontal = 20.dp, vertical = 36.dp)
      .testTag("pay_after_section")
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      // Trust Badge
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
          .clip(RoundedCornerShape(20.dp))
          .background(PureWhite.copy(alpha = 0.12f))
          .padding(horizontal = 12.dp, vertical = 6.dp)
      ) {
        Icon(
          imageVector = Icons.Default.VerifiedUser,
          contentDescription = "Zero Risk",
          tint = BrandCyan,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "Zero Risk • Pay After Approval",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = PureWhite
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Headline
      Text(
        text = "See Your Website Before You Pay",
        style = MaterialTheme.typography.displayMedium.copy(
          fontWeight = FontWeight.Bold,
          color = PureWhite,
          lineHeight = 34.sp
        )
      )

      Spacer(modifier = Modifier.height(12.dp))

      // Supporting Text
      Text(
        text = "We don't expect you to pay for an idea you haven't seen. We build your website first, show you what we've created, and if you love it, you pay and we finalize it for your business.",
        style = MaterialTheme.typography.bodyLarge.copy(
          color = PureWhite.copy(alpha = 0.9f),
          lineHeight = 24.sp
        )
      )

      Spacer(modifier = Modifier.height(28.dp))

      // 3-Step Process Cards
      Column(
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        BuildWebData.payAfterSteps.forEach { step ->
          Card(
            colors = CardDefaults.cardColors(
              containerColor = PureWhite.copy(alpha = 0.08f)
            ),
            border = androidx.compose.foundation.BorderStroke(1.dp, PureWhite.copy(alpha = 0.2f)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Row(
              modifier = Modifier.padding(16.dp),
              verticalAlignment = Alignment.Top
            ) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(BrandCyan),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = step.stepNumber,
                  fontWeight = FontWeight.Black,
                  fontSize = 13.sp,
                  color = BrandNavy
                )
              }

              Spacer(modifier = Modifier.width(14.dp))

              Column {
                Text(
                  text = step.title,
                  style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = PureWhite
                  )
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                  text = step.description,
                  style = MaterialTheme.typography.bodyMedium.copy(
                    color = PureWhite.copy(alpha = 0.85f),
                    lineHeight = 20.sp
                  )
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(28.dp))

      // CTA Button
      Button(
        onClick = onStartWebsite,
        colors = ButtonDefaults.buttonColors(
          containerColor = BrandBlue,
          contentColor = PureWhite
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(52.dp)
          .testTag("pay_after_cta_start")
      ) {
        Icon(
          imageVector = Icons.Default.Chat,
          contentDescription = "WhatsApp",
          tint = WhatsAppGreen,
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Start Your Website",
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
          )
        )
      }
    }
  }
}
