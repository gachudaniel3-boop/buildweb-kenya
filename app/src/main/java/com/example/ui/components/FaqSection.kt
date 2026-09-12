package com.example.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.model.FaqItem
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900

@Composable
fun FaqSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(Slate100)
      .padding(horizontal = 20.dp, vertical = 32.dp)
      .testTag("faq_section")
  ) {
    Text(
      text = "FREQUENTLY ASKED QUESTIONS",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "Common Questions",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "Everything you need to know about getting your business website designed, launched and supported.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    // FAQ Accordion
    Column(
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      BuildWebData.faqs.forEachIndexed { index, faq ->
        FaqAccordionCard(
          faq = faq,
          initiallyExpanded = index == 0 || index == 1
        )
      }
    }
  }
}

@Composable
private fun FaqAccordionCard(
  faq: FaqItem,
  initiallyExpanded: Boolean = false
) {
  var expanded by remember { mutableStateOf(initiallyExpanded) }

  Card(
    colors = CardDefaults.cardColors(containerColor = PureWhite),
    border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
    shape = RoundedCornerShape(10.dp),
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .clickable { expanded = !expanded }
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = faq.question,
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold,
            color = BrandNavy,
            fontSize = 15.sp
          ),
          modifier = Modifier.weight(1f)
        )

        Icon(
          imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
          contentDescription = if (expanded) "Collapse" else "Expand",
          tint = BrandBlue,
          modifier = Modifier.size(22.dp)
        )
      }

      AnimatedVisibility(
        visible = expanded,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
      ) {
        Column {
          Spacer(modifier = Modifier.height(10.dp))
          Text(
            text = faq.answer,
            style = MaterialTheme.typography.bodyMedium.copy(
              color = Slate700,
              lineHeight = 22.sp
            )
          )
        }
      }
    }
  }
}
