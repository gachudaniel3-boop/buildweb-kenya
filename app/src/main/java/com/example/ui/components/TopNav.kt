package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900
import com.example.ui.theme.WhatsAppGreen

@Composable
fun TopNav(
  onNavigateToSection: (String) -> Unit,
  onOpenWhatsAppConsultation: () -> Unit,
  modifier: Modifier = Modifier
) {
  var menuExpanded by remember { mutableStateOf(false) }

  Surface(
    modifier = modifier
      .fillMaxWidth()
      .shadow(elevation = 3.dp),
    color = PureWhite
  ) {
    Column(modifier = Modifier.fillMaxWidth()) {
      // Main Bar
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Logo & Tagline
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .clickable { onNavigateToSection("home") }
            .testTag("nav_logo")
        ) {
          Box(
            modifier = Modifier
              .size(36.dp)
              .clip(RoundedCornerShape(8.dp))
              .background(BrandNavy),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = "BW",
              color = PureWhite,
              fontWeight = FontWeight.Black,
              fontSize = 15.sp
            )
          }

          Spacer(modifier = Modifier.width(10.dp))

          Column {
            Text(
              text = "BuildWeb Kenya",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                color = BrandNavy
              )
            )
            Text(
              text = "Nairobi • Professional Web Agency",
              style = MaterialTheme.typography.bodySmall.copy(
                color = Slate700,
                fontSize = 11.sp
              )
            )
          }
        }

        // CTA Button and Menu
        Row(verticalAlignment = Alignment.CenterVertically) {
          Button(
            onClick = onOpenWhatsAppConsultation,
            colors = ButtonDefaults.buttonColors(
              containerColor = BrandNavy,
              contentColor = PureWhite
            ),
            shape = RoundedCornerShape(8.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
              horizontal = 12.dp,
              vertical = 8.dp
            ),
            modifier = Modifier.testTag("nav_book_consultation_button")
          ) {
            Icon(
              imageVector = Icons.Default.Chat,
              contentDescription = "WhatsApp",
              tint = WhatsAppGreen,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Consult",
              style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.SemiBold
              )
            )
          }

          Spacer(modifier = Modifier.width(4.dp))

          Box {
            IconButton(
              onClick = { menuExpanded = true },
              modifier = Modifier.testTag("nav_menu_button")
            ) {
              Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Slate900
              )
            }

            DropdownMenu(
              expanded = menuExpanded,
              onDismissRequest = { menuExpanded = false },
              modifier = Modifier.background(PureWhite)
            ) {
              val navItems = listOf(
                "Home" to "home",
                "Services" to "services",
                "Pricing" to "pricing",
                "Pay After You See It" to "pay_after",
                "Why Us" to "why_us",
                "Concepts" to "portfolio",
                "Industries" to "industries",
                "Reviews" to "reviews",
                "FAQ" to "faq",
                "Contact" to "contact"
              )

              navItems.forEach { (label, anchor) ->
                DropdownMenuItem(
                  text = {
                    Text(
                      text = label,
                      fontWeight = FontWeight.Medium,
                      color = Slate900
                    )
                  },
                  onClick = {
                    menuExpanded = false
                    onNavigateToSection(anchor)
                  }
                )
              }
            }
          }
        }
      }

      // Horizontal Quick Anchor Chips
      val chipsScroll = rememberScrollState()
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .background(Slate100)
          .horizontalScroll(chipsScroll)
          .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        val quickLinks = listOf(
          "Services" to "services",
          "Pricing" to "pricing",
          "Pay After You See It" to "pay_after",
          "Concepts" to "portfolio",
          "Why Us" to "why_us",
          "FAQ" to "faq",
          "Contact" to "contact"
        )

        quickLinks.forEach { (label, anchor) ->
          Box(
            modifier = Modifier
              .clip(RoundedCornerShape(16.dp))
              .background(PureWhite)
              .border(1.dp, Slate200, RoundedCornerShape(16.dp))
              .clickable { onNavigateToSection(anchor) }
              .padding(horizontal = 12.dp, vertical = 4.dp)
          ) {
            Text(
              text = label,
              fontSize = 12.sp,
              fontWeight = FontWeight.Medium,
              color = Slate700
            )
          }
        }
      }
    }
  }
}
