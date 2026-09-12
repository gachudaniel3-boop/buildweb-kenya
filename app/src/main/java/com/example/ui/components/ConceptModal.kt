package com.example.ui.components

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.model.DemoConcept
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900
import com.example.ui.theme.WhatsAppGreen

@Composable
fun ConceptDetailDialog(
  concept: DemoConcept,
  onDismiss: () -> Unit,
  onRequestThisConcept: (DemoConcept) -> Unit
) {
  Dialog(onDismissRequest = onDismiss) {
    Surface(
      shape = RoundedCornerShape(16.dp),
      color = PureWhite,
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .verticalScroll(rememberScrollState())
      ) {
        // Concept Hero Bar
        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(Color(concept.heroColorHex))
            .padding(16.dp)
        ) {
          IconButton(
            onClick = onDismiss,
            modifier = Modifier.align(Alignment.TopEnd)
          ) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Close",
              tint = PureWhite
            )
          }

          Column(modifier = Modifier.align(Alignment.BottomStart)) {
            Box(
              modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .background(PureWhite.copy(alpha = 0.25f))
                .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
              Text(
                text = "${concept.industry} • DEMO CONCEPT",
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = PureWhite
              )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
              text = concept.title,
              style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold,
                color = PureWhite
              )
            )
          }
        }

        // Details Body
        Column(modifier = Modifier.padding(20.dp)) {
          Text(
            text = concept.tagline,
            style = MaterialTheme.typography.bodyLarge.copy(
              fontWeight = FontWeight.Medium,
              color = Slate900
            )
          )

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = "Ideal For:",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Slate700
          )
          Text(
            text = concept.suitableFor,
            style = MaterialTheme.typography.bodyMedium.copy(color = Slate700)
          )

          Spacer(modifier = Modifier.height(16.dp))

          Text(
            text = "Key System Features:",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = BrandNavy
          )

          Spacer(modifier = Modifier.height(6.dp))

          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            concept.keyFeatures.forEach { feat ->
              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                  imageVector = Icons.Default.CheckCircle,
                  contentDescription = null,
                  tint = BrandBlue,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = feat,
                  fontSize = 13.sp,
                  color = Slate900
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          Text(
            text = "Included Page Modules:",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = BrandNavy
          )

          Spacer(modifier = Modifier.height(6.dp))

          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            concept.sampleModules.forEach { mod ->
              Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                  modifier = Modifier
                    .size(6.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .background(BrandBlue)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = mod,
                  fontSize = 13.sp,
                  color = Slate700
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(20.dp))

          // Zero-Risk Reminder
          Card(
            colors = CardDefaults.cardColors(containerColor = Slate100),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            Text(
              text = "Remember: We build your initial concept first. You only pay after you review and approve the design!",
              fontSize = 12.sp,
              color = BrandNavy,
              modifier = Modifier.padding(12.dp),
              lineHeight = 16.sp
            )
          }

          Spacer(modifier = Modifier.height(20.dp))

          Button(
            onClick = {
              onRequestThisConcept(concept)
              onDismiss()
            },
            colors = ButtonDefaults.buttonColors(
              containerColor = BrandNavy,
              contentColor = PureWhite
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Chat,
              contentDescription = "WhatsApp",
              tint = WhatsAppGreen,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Request a Website Like This",
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp
            )
          }
        }
      }
    }
  }
}
