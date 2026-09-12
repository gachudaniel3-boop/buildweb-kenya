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
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Star
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.BuildWebData
import com.example.model.PricingPackage
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
fun PricingSection(
  onSelectPackage: (PricingPackage) -> Unit,
  onCustomQuoteRequest: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(Slate50Safe)
      .padding(horizontal = 20.dp, vertical = 32.dp)
  ) {
    // Section Title
    Text(
      text = "PRICING",
      fontSize = 12.sp,
      fontWeight = FontWeight.Bold,
      letterSpacing = 1.sp,
      color = BrandBlue
    )

    Spacer(modifier = Modifier.height(6.dp))

    Text(
      text = "Simple, Transparent Pricing",
      style = MaterialTheme.typography.headlineMedium.copy(
        fontWeight = FontWeight.Bold,
        color = BrandNavy
      )
    )

    Spacer(modifier = Modifier.height(8.dp))

    Text(
      text = "Choose the package that fits your business. No confusing pricing.",
      style = MaterialTheme.typography.bodyLarge.copy(
        color = Slate700,
        lineHeight = 22.sp
      )
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Pricing Cards Stacked Vertically
    Column(
      verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
      BuildWebData.pricingPackages.forEach { pkg ->
        PricingCard(
          pkg = pkg,
          onSelect = { onSelectPackage(pkg) }
        )
      }
    }

    Spacer(modifier = Modifier.height(20.dp))

    // Note below pricing
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(PureWhite)
        .border(1.dp, Slate200, RoundedCornerShape(10.dp))
        .clickable { onCustomQuoteRequest() }
        .padding(16.dp),
      contentAlignment = Alignment.Center
    ) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          imageVector = Icons.Default.Chat,
          contentDescription = "Contact",
          tint = WhatsAppGreen,
          modifier = Modifier.size(18.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = "Need something different? Contact us for a custom quote.",
          style = MaterialTheme.typography.bodyMedium.copy(
            fontWeight = FontWeight.SemiBold,
            color = BrandNavy
          )
        )
      }
    }
  }
}

@Composable
private fun PricingCard(
  pkg: PricingPackage,
  onSelect: () -> Unit
) {
  val isPopular = pkg.isPopular

  Card(
    colors = CardDefaults.cardColors(
      containerColor = PureWhite
    ),
    border = if (isPopular) {
      androidx.compose.foundation.BorderStroke(2.dp, BrandBlue)
    } else {
      androidx.compose.foundation.BorderStroke(1.dp, Slate200)
    },
    shape = RoundedCornerShape(14.dp),
    modifier = Modifier
      .fillMaxWidth()
      .shadow(if (isPopular) 8.dp else 2.dp, RoundedCornerShape(14.dp))
      .testTag("pricing_card_${pkg.id}")
  ) {
    Column(modifier = Modifier.padding(20.dp)) {
      if (isPopular) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(16.dp))
              .background(BrandNavy)
              .padding(horizontal = 12.dp, vertical = 4.dp)
          ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = Color(0xFFF59E0B),
                modifier = Modifier.size(14.dp)
              )
              Spacer(modifier = Modifier.width(4.dp))
              Text(
                text = "MOST POPULAR",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PureWhite
              )
            }
          }

          Text(
            text = "Best Value",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = BrandBlue
          )
        }
        Spacer(modifier = Modifier.height(12.dp))
      }

      Text(
        text = pkg.name,
        style = MaterialTheme.typography.titleMedium.copy(
          fontWeight = FontWeight.Bold,
          letterSpacing = 0.5.sp,
          color = if (isPopular) BrandBlue else Slate700
        )
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = pkg.priceDisplay,
        style = MaterialTheme.typography.displayMedium.copy(
          fontWeight = FontWeight.Black,
          color = BrandNavy
        )
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = pkg.targetAudience,
        style = MaterialTheme.typography.bodyMedium.copy(
          color = Slate700,
          lineHeight = 20.sp
        )
      )

      Spacer(modifier = Modifier.height(16.dp))

      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(1.dp)
          .background(Slate200)
      )

      Spacer(modifier = Modifier.height(16.dp))

      // Features List
      Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        pkg.features.forEach { feature ->
          Row(
            verticalAlignment = Alignment.CenterVertically
          ) {
            Box(
              modifier = Modifier
                .size(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(if (isPopular) BrandBlueLight else Slate100),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Included",
                tint = if (isPopular) BrandBlue else BrandNavy,
                modifier = Modifier.size(14.dp)
              )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Text(
              text = feature,
              style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Medium,
                color = Slate900
              )
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // CTA
      if (isPopular) {
        Button(
          onClick = onSelect,
          colors = ButtonDefaults.buttonColors(
            containerColor = BrandBlue,
            contentColor = PureWhite
          ),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("pricing_cta_${pkg.id}")
        ) {
          Icon(
            imageVector = Icons.Default.Chat,
            contentDescription = "WhatsApp",
            tint = WhatsAppGreen,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = pkg.ctaText,
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold
            )
          )
        }
      } else {
        OutlinedButton(
          onClick = onSelect,
          shape = RoundedCornerShape(10.dp),
          border = androidx.compose.foundation.BorderStroke(1.5.dp, BrandNavy),
          colors = ButtonDefaults.outlinedButtonColors(
            contentColor = BrandNavy
          ),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("pricing_cta_${pkg.id}")
        ) {
          Icon(
            imageVector = Icons.Default.Chat,
            contentDescription = "WhatsApp",
            tint = BrandNavy,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = pkg.ctaText,
            style = MaterialTheme.typography.titleSmall.copy(
              fontWeight = FontWeight.Bold
            )
          )
        }
      }
    }
  }
}

private val Slate50Safe = Color(0xFFF8FAFC)
