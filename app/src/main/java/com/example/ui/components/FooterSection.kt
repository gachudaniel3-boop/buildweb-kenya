package com.example.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate400
import com.example.ui.theme.Slate500
import com.example.ui.theme.WhatsAppGreen
import com.example.util.WhatsAppHelper

@Composable
fun FooterSection(
  onNavigateToSection: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current

  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(BrandNavy)
      .padding(horizontal = 20.dp, vertical = 36.dp)
      .testTag("footer_section")
  ) {
    // Brand Name & Tagline
    Row(verticalAlignment = Alignment.CenterVertically) {
      Box(
        modifier = Modifier
          .size(36.dp)
          .clip(RoundedCornerShape(8.dp))
          .background(PureWhite),
        contentAlignment = Alignment.Center
      ) {
        Text(
          text = "BW",
          color = BrandNavy,
          fontWeight = FontWeight.Black,
          fontSize = 15.sp
        )
      }

      Spacer(modifier = Modifier.width(10.dp))

      Text(
        text = "BuildWeb Kenya",
        style = MaterialTheme.typography.titleLarge.copy(
          fontWeight = FontWeight.Bold,
          color = PureWhite
        )
      )
    }

    Spacer(modifier = Modifier.height(10.dp))

    Text(
      text = "Professional Websites. Affordable Prices. Built for Kenyan Businesses.",
      style = MaterialTheme.typography.bodyMedium.copy(
        color = PureWhite.copy(alpha = 0.85f),
        lineHeight = 20.sp
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(PureWhite.copy(alpha = 0.15f))
    )

    Spacer(modifier = Modifier.height(20.dp))

    // Navigation Links
    Text(
      text = "QUICK NAVIGATION",
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = Slate400
    )

    Spacer(modifier = Modifier.height(12.dp))

    val footerLinks = listOf(
      "Home" to "home",
      "Services" to "services",
      "Pricing" to "pricing",
      "Why Us" to "why_us",
      "Reviews" to "reviews",
      "FAQ" to "faq",
      "Contact" to "contact"
    )

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
      footerLinks.forEach { (title, anchor) ->
        Text(
          text = title,
          color = PureWhite,
          fontSize = 14.sp,
          fontWeight = FontWeight.Medium,
          modifier = Modifier
            .clickable { onNavigateToSection(anchor) }
            .padding(vertical = 2.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(1.dp)
        .background(PureWhite.copy(alpha = 0.15f))
    )

    Spacer(modifier = Modifier.height(20.dp))

    // Contact Details
    Text(
      text = "DIRECT CONTACT",
      fontSize = 11.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = Slate400
    )

    Spacer(modifier = Modifier.height(12.dp))

    // WhatsApp
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .clickable {
          WhatsAppHelper.openWhatsApp(
            context,
            "Hello BuildWeb Kenya, I'd like to discuss getting a website for my business."
          )
        }
        .padding(vertical = 4.dp)
    ) {
      Icon(
        imageVector = Icons.Default.Chat,
        contentDescription = "WhatsApp",
        tint = WhatsAppGreen,
        modifier = Modifier.size(18.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = "WhatsApp: 0758841056",
        color = PureWhite,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
      )
    }

    // M-Pesa Till
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
        .clickable {
          WhatsAppHelper.copyToClipboard(context, "1700111", "M-Pesa Till: 1700111 copied to clipboard")
        }
        .padding(vertical = 4.dp)
    ) {
      Icon(
        imageVector = Icons.Default.Payment,
        contentDescription = "M-Pesa Till",
        tint = PureWhite,
        modifier = Modifier.size(18.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = "M-Pesa Till: 1700111",
        color = PureWhite,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
      )
    }

    // Location
    Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier.padding(vertical = 4.dp)
    ) {
      Icon(
        imageVector = Icons.Default.LocationOn,
        contentDescription = "Location",
        tint = PureWhite,
        modifier = Modifier.size(18.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(
        text = "Nairobi, Kenya",
        color = PureWhite,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
      )
    }

    Spacer(modifier = Modifier.height(28.dp))

    // Copyright
    Text(
      text = "© 2026 BuildWeb Kenya. All rights reserved.",
      color = Slate400,
      fontSize = 12.sp,
      lineHeight = 18.sp
    )
  }
}
