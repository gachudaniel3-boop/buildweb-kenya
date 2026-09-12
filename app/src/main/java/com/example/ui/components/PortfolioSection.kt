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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Info
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.model.DemoConcept
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandBlueLight
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900

@Composable
fun PortfolioSection(
  onSelectConcept: (DemoConcept) -> Unit,
  onRequestConcept: (DemoConcept) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(Color(0xFFF8FAFC))
      .padding(horizontal = 20.dp, vertical = 32.dp)
      .testTag("portfolio_section")
  ) {
    // Header
    Text(
      text = "DEMO CONCEPTS",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "What We Can Build For Your Business",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "Explore interactive website demo concepts across popular Kenyan industries. Clearly labeled as demo concepts showing our design standards.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(14.dp))

    // Demo Label Notice
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .background(BrandBlueLight)
        .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          imageVector = Icons.Default.Info,
          contentDescription = "Demo notice",
          tint = BrandBlue,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Demo Concepts • Custom-crafted to order with Pay After Approval",
          fontSize = 11.sp,
          fontWeight = FontWeight.Medium,
          color = BrandNavy
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Industry Demo Concept Cards
    Column(
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      BuildWebData.demoConcepts.forEach { concept ->
        DemoConceptCard(
          concept = concept,
          onViewDetails = { onSelectConcept(concept) },
          onRequest = { onRequestConcept(concept) }
        )
      }
    }
  }
}

@Composable
private fun DemoConceptCard(
  concept: DemoConcept,
  onViewDetails: () -> Unit,
  onRequest: () -> Unit
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = PureWhite),
    border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
    shape = RoundedCornerShape(12.dp),
    modifier = Modifier
      .fillMaxWidth()
      .shadow(3.dp, RoundedCornerShape(12.dp))
      .clickable { onViewDetails() }
      .testTag("concept_card_${concept.id}")
  ) {
    Column {
      // Mockup Top Bar Visual
      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(110.dp)
          .background(Color(concept.heroColorHex))
          .padding(16.dp)
      ) {
        Column(
          modifier = Modifier.align(Alignment.BottomStart)
        ) {
          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(6.dp))
              .background(PureWhite.copy(alpha = 0.25f))
              .padding(horizontal = 8.dp, vertical = 2.dp)
          ) {
            Text(
              text = concept.industry.uppercase(),
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = PureWhite
            )
          }

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = concept.title,
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              color = PureWhite
            )
          )
        }

        Box(
          modifier = Modifier
            .align(Alignment.TopEnd)
            .clip(RoundedCornerShape(12.dp))
            .background(PureWhite.copy(alpha = 0.2f))
            .padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Devices,
              contentDescription = "Responsive",
              tint = PureWhite,
              modifier = Modifier.size(12.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
              text = "Demo Concept",
              fontSize = 10.sp,
              fontWeight = FontWeight.SemiBold,
              color = PureWhite
            )
          }
        }
      }

      // Card Body
      Column(modifier = Modifier.padding(16.dp)) {
        Text(
          text = concept.tagline,
          style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.Medium,
            color = Slate900
          )
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Features Preview
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          concept.keyFeatures.take(3).forEach { feature ->
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Feature",
                tint = BrandBlue,
                modifier = Modifier.size(14.dp)
              )
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = feature,
                fontSize = 12.sp,
                color = Slate700
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Actions
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = "Tap for full spec",
            fontSize = 12.sp,
            color = BrandBlue,
            fontWeight = FontWeight.SemiBold
          )

          Button(
            onClick = onRequest,
            colors = ButtonDefaults.buttonColors(
              containerColor = BrandNavy,
              contentColor = PureWhite
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
              horizontal = 12.dp,
              vertical = 6.dp
            ),
            modifier = Modifier.testTag("concept_request_btn_${concept.id}")
          ) {
            Text(
              text = "Request a Website Like This",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowForward,
              contentDescription = "Request",
              modifier = Modifier.size(14.dp)
            )
          }
        }
      }
    }
  }
}
