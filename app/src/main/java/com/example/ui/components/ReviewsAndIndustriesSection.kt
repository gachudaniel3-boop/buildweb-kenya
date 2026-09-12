package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.RateReview
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.model.IndustryCategory
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandBlueLight
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900
import com.example.ui.theme.WhatsAppGreen

@Composable
fun ReviewsAndIndustriesSection(
  onContactUs: () -> Unit,
  onIndustrySelected: (IndustryCategory) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(PureWhite)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    // REVIEWS SECTION
    Text(
      text = "CLIENT EXPERIENCES",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "What Our Clients Say",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(16.dp))

    // Genuine Reviews Placeholder Card (Per Strict Prompt Rules: Never Fabricate Reviews!)
    Card(
      colors = CardDefaults.cardColors(containerColor = Slate100),
      border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
      shape = RoundedCornerShape(14.dp),
      modifier = Modifier
        .fillMaxWidth()
        .shadow(2.dp, RoundedCornerShape(14.dp))
        .testTag("reviews_placeholder_card")
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Box(
          modifier = Modifier
            .size(52.dp)
            .clip(RoundedCornerShape(26.dp))
            .background(BrandBlueLight),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.RateReview,
            contentDescription = "Review",
            tint = BrandBlue,
            modifier = Modifier.size(28.dp)
          )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = "Your business could be next.",
          style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
            color = BrandNavy
          ),
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "We are currently onboarding Kenyan businesses with our risk-free 'Pay After You See It' service. Let us build your website first—see what we can create for your brand before spending a single shilling.",
          style = MaterialTheme.typography.bodyMedium.copy(
            color = Slate700,
            lineHeight = 22.sp
          ),
          textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
          onClick = onContactUs,
          colors = ButtonDefaults.buttonColors(
            containerColor = BrandNavy,
            contentColor = PureWhite
          ),
          shape = RoundedCornerShape(8.dp)
        ) {
          Icon(
            imageVector = Icons.Default.Chat,
            contentDescription = "Contact",
            tint = WhatsAppGreen,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Become Our Next Success Story",
            style = MaterialTheme.typography.labelLarge.copy(
              fontWeight = FontWeight.Bold
            )
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(44.dp))

    // INDUSTRIES SECTION
    Text(
      text = "TARGET INDUSTRIES",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "Websites for Every Type of Business",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "BuildWeb Kenya builds custom websites designed specifically around the distinct operational models and customers of diverse Kenyan industries.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(20.dp))

    // 14 Clean Industry Cards (2 columns)
    Column(
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      BuildWebData.industries.chunked(2).forEach { pair ->
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          pair.forEach { ind ->
            Box(
              modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(PureWhite)
                .border(1.dp, Slate200, RoundedCornerShape(10.dp))
                .clickable { onIndustrySelected(ind) }
                .padding(horizontal = 12.dp, vertical = 10.dp)
            ) {
              Row(
                verticalAlignment = Alignment.CenterVertically
              ) {
                Box(
                  modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(BrandBlueLight),
                  contentAlignment = Alignment.Center
                ) {
                  Icon(
                    imageVector = ind.icon,
                    contentDescription = ind.name,
                    tint = BrandBlue,
                    modifier = Modifier.size(18.dp)
                  )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                  text = ind.name,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = BrandNavy,
                  lineHeight = 16.sp
                )
              }
            }
          }
          if (pair.size == 1) {
            Spacer(modifier = Modifier.weight(1f))
          }
        }
      }
    }
  }
}
