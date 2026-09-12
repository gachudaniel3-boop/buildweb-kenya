package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
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
fun HeroSection(
  onBookConsultation: () -> Unit,
  onViewPricing: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(PureWhite)
      .padding(horizontal = 20.dp, vertical = 24.dp)
  ) {
    // Agency Tagline Pill
    Box(
      modifier = Modifier
        .clip(RoundedCornerShape(20.dp))
        .background(BrandBlueLight)
        .border(1.dp, BrandBlue.copy(alpha = 0.2f), RoundedCornerShape(20.dp))
        .padding(horizontal = 14.dp, vertical = 6.dp)
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
          modifier = Modifier
            .size(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(BrandBlue)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Professional Websites. Affordable Prices. Built for Kenyan Businesses.",
          fontSize = 11.sp,
          fontWeight = FontWeight.SemiBold,
          color = BrandNavy
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Main Headline
    Text(
      text = "Professional Websites for Kenyan Businesses",
      style = MaterialTheme.typography.displayMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy,
        lineHeight = 36.sp
      )
    )

    Spacer(modifier = Modifier.height(12.dp))

    // Supporting text
    Text(
      text = "We design fast, modern and mobile-friendly websites that help businesses look professional, reach more customers and grow online.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 24.sp
      )
    )

    Spacer(modifier = Modifier.height(20.dp))

    // Key Differentiator Card Prominently Displayed
    Card(
      colors = CardDefaults.cardColors(
        containerColor = BrandNavy
      ),
      shape = RoundedCornerShape(12.dp),
      modifier = Modifier
        .fillMaxWidth()
        .shadow(4.dp, RoundedCornerShape(12.dp))
        .testTag("hero_key_differentiator_card")
    ) {
      Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.Top
      ) {
        Box(
          modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(PureWhite.copy(alpha = 0.15f)),
          contentAlignment = Alignment.Center
        ) {
          Icon(
            imageVector = Icons.Default.Visibility,
            contentDescription = "Zero Risk",
            tint = PureWhite,
            modifier = Modifier.size(20.dp)
          )
        }

        Spacer(modifier = Modifier.width(14.dp))

        Column {
          Text(
            text = "We build your website before you pay.",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              color = PureWhite
            )
          )

          Spacer(modifier = Modifier.height(4.dp))

          Text(
            text = "See what your website could look like before making a payment. If you love it, we finalize it for your business.",
            style = MaterialTheme.typography.bodyMedium.copy(
              color = PureWhite.copy(alpha = 0.9f),
              lineHeight = 20.sp
            )
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))

    // CTAs (Primary & Secondary)
    Column(
      modifier = Modifier.fillMaxWidth(),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      Button(
        onClick = onBookConsultation,
        colors = ButtonDefaults.buttonColors(
          containerColor = BrandBlue,
          contentColor = PureWhite
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(50.dp)
          .testTag("hero_cta_book_consultation")
      ) {
        Icon(
          imageVector = Icons.Default.Chat,
          contentDescription = "WhatsApp",
          tint = WhatsAppGreen,
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Book a Free Consultation",
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.Bold
          )
        )
      }

      OutlinedButton(
        onClick = onViewPricing,
        shape = RoundedCornerShape(10.dp),
        border = androidx.compose.foundation.BorderStroke(1.5.dp, BrandNavy),
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = BrandNavy
        ),
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
          .testTag("hero_cta_view_pricing")
      ) {
        Text(
          text = "View Our Pricing",
          style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.SemiBold
          )
        )
        Spacer(modifier = Modifier.width(6.dp))
        Icon(
          imageVector = Icons.AutoMirrored.Filled.ArrowForward,
          contentDescription = "Arrow",
          modifier = Modifier.size(18.dp)
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Visual Mockup of Modern Business Website on Laptop and Smartphone
    Card(
      colors = CardDefaults.cardColors(containerColor = PureWhite),
      border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
      shape = RoundedCornerShape(16.dp),
      modifier = Modifier
        .fillMaxWidth()
        .shadow(6.dp, RoundedCornerShape(16.dp))
    ) {
      Column {
        // Mockup Header Strip
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .background(Slate100)
            .padding(horizontal = 14.dp, vertical = 8.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFEF4444)))
            Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFF59E0B)))
            Box(modifier = Modifier.size(8.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFF10B981)))
          }

          Text(
            text = "Modern Responsive Architecture • Laptop & Mobile",
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = Slate600
          )
        }

        Image(
          painter = painterResource(id = R.drawable.img_hero_mockup_1789212886262),
          contentDescription = "Modern business website mockup displayed on laptop and smartphone",
          modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9f),
          contentScale = ContentScale.Crop
        )

        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 10.dp),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.CheckCircle,
              contentDescription = "Check",
              tint = BrandBlue,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Live preview before any upfront payment",
              fontSize = 12.sp,
              fontWeight = FontWeight.Medium,
              color = Slate700
            )
          }

          Text(
            text = "Starting KSh 10,000",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = BrandBlue
          )
        }
      }
    }
  }
}
