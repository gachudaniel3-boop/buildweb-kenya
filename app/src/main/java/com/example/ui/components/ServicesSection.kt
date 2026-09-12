package com.example.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
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
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.model.ServiceItem
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
fun ServicesSection(
  onServiceInquire: (ServiceItem) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(PureWhite)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    // Section Header
    Text(
      text = "SERVICES",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "Everything Your Business Needs Online",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "From a simple business website to a complete online store, we build solutions designed around your business.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Services Cards
    Column(
      verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
      BuildWebData.services.forEach { service ->
        ServiceCard(
          service = service,
          onClick = { onServiceInquire(service) }
        )
      }
    }
  }
}

@Composable
private fun ServiceCard(
  service: ServiceItem,
  onClick: () -> Unit
) {
  val interactionSource = remember { MutableInteractionSource() }
  val isPressed by interactionSource.collectIsPressedAsState()
  val scale by animateFloatAsState(if (isPressed) 0.98f else 1.0f, label = "card_press")

  Card(
    colors = CardDefaults.cardColors(containerColor = PureWhite),
    border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
    shape = RoundedCornerShape(12.dp),
    modifier = Modifier
      .fillMaxWidth()
      .scale(scale)
      .shadow(elevation = if (isPressed) 1.dp else 3.dp, shape = RoundedCornerShape(12.dp))
      .clickable(interactionSource = interactionSource, indication = null) { onClick() }
      .testTag("service_card_${service.id}")
  ) {
    Column(modifier = Modifier.padding(18.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(44.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(BrandBlueLight),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = service.icon,
            contentDescription = service.title,
            tint = BrandBlue,
            modifier = Modifier.size(24.dp)
          )
        }

        Box(
          modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(Slate100)
            .padding(horizontal = 10.dp, vertical = 4.dp)
        ) {
          Text(
            text = service.tag,
            fontSize = 11.sp,
            fontWeight = FontWeight.SemiBold,
            color = Slate700
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(
        text = service.title,
        style = MaterialTheme.typography.titleMedium.copy(
          fontWeight = FontWeight.Bold,
          color = BrandNavy
        )
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = service.description,
        style = MaterialTheme.typography.bodyMedium.copy(
          color = Slate700,
          lineHeight = 20.sp
        )
      )

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Icon(
          imageVector = Icons.Default.Chat,
          contentDescription = "WhatsApp",
          tint = WhatsAppGreen,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "Ask about ${service.title}",
          fontSize = 13.sp,
          fontWeight = FontWeight.SemiBold,
          color = BrandBlue
        )
        Spacer(modifier = Modifier.width(4.dp))
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = "Go",
          tint = BrandBlue,
          modifier = Modifier.size(14.dp)
        )
      }
    }
  }
}
