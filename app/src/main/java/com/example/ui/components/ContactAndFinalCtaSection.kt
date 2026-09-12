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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.FormUiState
import com.example.ui.theme.BrandBlue
import com.example.ui.theme.BrandBlueLight
import com.example.ui.theme.BrandCyan
import com.example.ui.theme.BrandNavy
import com.example.ui.theme.MPesaGreen
import com.example.ui.theme.PureWhite
import com.example.ui.theme.Slate100
import com.example.ui.theme.Slate200
import com.example.ui.theme.Slate600
import com.example.ui.theme.Slate700
import com.example.ui.theme.Slate900
import com.example.ui.theme.WhatsAppGreen
import com.example.util.WhatsAppHelper

@Composable
fun ContactAndFinalCtaSection(
  formState: FormUiState,
  onSubmitRequest: (name: String, businessName: String, phone: String, type: String, websiteNeeded: String, message: String) -> Unit,
  onBookConsultation: () -> Unit,
  onViewPricing: () -> Unit,
  modifier: Modifier = Modifier
) {
  val context = LocalContext.current
  var name by remember { mutableStateOf("") }
  var businessName by remember { mutableStateOf("") }
  var phone by remember { mutableStateOf("") }
  var businessType by remember { mutableStateOf("") }
  var websiteNeeded by remember { mutableStateOf("Starter Website (KSh 10,000)") }
  var message by remember { mutableStateOf("") }

  Column(
    modifier = modifier
      .fillMaxWidth()
      .background(PureWhite)
  ) {
    // FINAL CONVERSION CTA STRIP
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(BrandNavy)
        .padding(horizontal = 20.dp, vertical = 36.dp)
        .testTag("final_cta_section")
    ) {
      Column(modifier = Modifier.fillMaxWidth()) {
        Text(
          text = "Your Customers Are Already Online. Is Your Business Ready?",
          style = MaterialTheme.typography.headlineMedium.copy(
            fontWeight = FontWeight.Bold,
            color = PureWhite,
            lineHeight = 32.sp
          )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
          text = "Give your business a professional online presence without paying thousands before you even see what you're getting.",
          style = MaterialTheme.typography.bodyLarge.copy(
            color = PureWhite.copy(alpha = 0.9f),
            lineHeight = 22.sp
          )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Direct WhatsApp Contact Ribbon
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(PureWhite.copy(alpha = 0.12f))
            .clickable {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to book a free website consultation."
              )
            }
            .padding(horizontal = 14.dp, vertical = 10.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
              imageVector = Icons.Default.Chat,
              contentDescription = "WhatsApp",
              tint = WhatsAppGreen,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "WhatsApp: 0758841056",
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp,
              color = PureWhite
            )
          }

          Text(
            text = "Tap to Chat",
            fontSize = 12.sp,
            color = BrandCyan,
            fontWeight = FontWeight.SemiBold
          )
        }

        Spacer(modifier = Modifier.height(18.dp))

        // CTAs
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
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
              .testTag("final_cta_book_consultation")
          ) {
            Icon(
              imageVector = Icons.Default.Chat,
              contentDescription = "WhatsApp",
              tint = WhatsAppGreen,
              modifier = Modifier.size(18.dp)
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
            border = androidx.compose.foundation.BorderStroke(1.5.dp, PureWhite),
            colors = ButtonDefaults.outlinedButtonColors(
              contentColor = PureWhite
            ),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
              .testTag("final_cta_view_pricing")
          ) {
            Text(
              text = "View Pricing",
              style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold
              )
            )
          }
        }
      }
    }

    // CONTACT SECTION
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 36.dp)
        .testTag("contact_section")
    ) {
      Text(
        text = "GET IN TOUCH",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 1.sp,
        color = BrandBlue
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = "Let's Build Your Website",
        style = MaterialTheme.typography.headlineMedium.copy(
          fontWeight = FontWeight.Bold,
          color = BrandNavy
        )
      )

      Spacer(modifier = Modifier.height(8.dp))

      Text(
        text = "Tell us about your business and what you'd like your website to do.",
        style = MaterialTheme.typography.bodyLarge.copy(
          color = Slate700,
          lineHeight = 22.sp
        )
      )

      Spacer(modifier = Modifier.height(20.dp))

      // Direct WhatsApp Action Card
      Card(
        colors = CardDefaults.cardColors(containerColor = BrandBlueLight),
        border = androidx.compose.foundation.BorderStroke(1.dp, BrandBlue.copy(alpha = 0.2f)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            WhatsAppHelper.openWhatsApp(
              context,
              "Hello BuildWeb Kenya, I'd like to book a free website consultation."
            )
          }
      ) {
        Row(
          modifier = Modifier.padding(16.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(WhatsAppGreen),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Chat,
                contentDescription = "WhatsApp",
                tint = PureWhite,
                modifier = Modifier.size(24.dp)
              )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
              Text(
                text = "Instant WhatsApp Consultation",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = BrandNavy
              )
              Text(
                text = "WhatsApp: 0758841056",
                fontSize = 13.sp,
                color = Slate700
              )
            }
          }

          Text(
            text = "Chat Now",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = BrandBlue
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // M-Pesa Till Card
      Card(
        colors = CardDefaults.cardColors(containerColor = Slate100),
        border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .clickable {
            WhatsAppHelper.copyToClipboard(context, "1700111", "M-Pesa Till: 1700111 copied to clipboard")
          }
      ) {
        Row(
          modifier = Modifier.padding(16.dp),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(MPesaGreen),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = Icons.Default.Payment,
                contentDescription = "M-Pesa",
                tint = PureWhite,
                modifier = Modifier.size(22.dp)
              )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column {
              Text(
                text = "Official M-Pesa Till: 1700111",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = BrandNavy
              )
              Text(
                text = "Pay only after reviewing your live concept",
                fontSize = 12.sp,
                color = Slate600
              )
            }
          }

          Icon(
            imageVector = Icons.Default.ContentCopy,
            contentDescription = "Copy Till",
            tint = Slate700,
            modifier = Modifier.size(20.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(28.dp))

      // Interactive Contact Form
      Card(
        colors = CardDefaults.cardColors(containerColor = PureWhite),
        border = androidx.compose.foundation.BorderStroke(1.dp, Slate200),
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
          .fillMaxWidth()
          .shadow(3.dp, RoundedCornerShape(14.dp))
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          Text(
            text = "Request a Free Website Proposal",
            style = MaterialTheme.typography.titleMedium.copy(
              fontWeight = FontWeight.Bold,
              color = BrandNavy
            )
          )

          Spacer(modifier = Modifier.height(16.dp))

          // Name
          OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Your Name *") },
            placeholder = { Text("e.g. Mary Wanjiku") },
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_contact_name"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Business Name
          OutlinedTextField(
            value = businessName,
            onValueChange = { businessName = it },
            label = { Text("Business Name") },
            placeholder = { Text("e.g. Wanjiku Safari Tours") },
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_business_name"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Phone Number
          OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number / WhatsApp *") },
            placeholder = { Text("e.g. 0712 345 678") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_phone_number"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Business Type
          OutlinedTextField(
            value = businessType,
            onValueChange = { businessType = it },
            label = { Text("Business Type / Industry") },
            placeholder = { Text("e.g. Restaurant, Salon, Real Estate, E-commerce") },
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_business_type"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Website Needed
          OutlinedTextField(
            value = websiteNeeded,
            onValueChange = { websiteNeeded = it },
            label = { Text("Website Needed") },
            placeholder = { Text("Starter, Business, Premium, Redesign, or Custom") },
            singleLine = true,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_website_needed"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Message
          OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Message / Specific Features Needed") },
            placeholder = { Text("Tell us what features your website should include...") },
            minLines = 3,
            maxLines = 5,
            modifier = Modifier
              .fillMaxWidth()
              .testTag("input_message"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = BrandBlue,
              unfocusedBorderColor = Slate200
            )
          )

          Spacer(modifier = Modifier.height(20.dp))

          // Submit Button
          val isSubmitting = formState is FormUiState.Submitting
          Button(
            onClick = {
              onSubmitRequest(name, businessName, phone, businessType, websiteNeeded, message)
            },
            enabled = !isSubmitting,
            colors = ButtonDefaults.buttonColors(
              containerColor = BrandNavy,
              contentColor = PureWhite
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(50.dp)
              .testTag("submit_contact_form_btn")
          ) {
            if (isSubmitting) {
              CircularProgressIndicator(
                color = PureWhite,
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text("Submitting...")
            } else {
              Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send",
                modifier = Modifier.size(18.dp)
              )
              Spacer(modifier = Modifier.width(8.dp))
              Text(
                text = "Send Request",
                style = MaterialTheme.typography.titleMedium.copy(
                  fontWeight = FontWeight.Bold
                )
              )
            }
          }
        }
      }
    }
  }
}
