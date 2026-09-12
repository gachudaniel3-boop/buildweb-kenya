package com.example.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import java.net.URLEncoder

object WhatsAppHelper {
  const val PHONE_NUMBER_DISPLAY = "0758841056"
  const val PHONE_NUMBER_INTL = "+254758841056"
  const val PHONE_NUMBER_CLEAN = "254758841056"
  const val MPESA_TILL = "1700111"

  fun openWhatsApp(context: Context, prefilledMessage: String) {
    try {
      val encodedText = URLEncoder.encode(prefilledMessage, "UTF-8")
      val url = "https://wa.me/$PHONE_NUMBER_CLEAN?text=$encodedText"
      val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      // Fallback: Copy to clipboard and open dialer
      copyToClipboard(context, PHONE_NUMBER_DISPLAY, "Phone number copied to clipboard")
      Toast.makeText(context, "Opening dialer: $PHONE_NUMBER_DISPLAY", Toast.LENGTH_SHORT).show()
      openDialer(context)
    }
  }

  fun openDialer(context: Context) {
    try {
      val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$PHONE_NUMBER_INTL")).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
      }
      context.startActivity(intent)
    } catch (e: Exception) {
      copyToClipboard(context, PHONE_NUMBER_DISPLAY, "Phone number copied to clipboard")
    }
  }

  fun copyToClipboard(context: Context, text: String, toastMessage: String) {
    try {
      val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
      val clip = ClipData.newPlainText("BuildWeb Kenya", text)
      clipboard.setPrimaryClip(clip)
      Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
      Toast.makeText(context, "Copied: $text", Toast.LENGTH_SHORT).show()
    }
  }
}
