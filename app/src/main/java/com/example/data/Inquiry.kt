package com.example.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inquiries")
data class Inquiry(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,
  val name: String,
  val businessName: String,
  val phoneNumber: String,
  val businessType: String,
  val websiteNeeded: String,
  val message: String,
  val timestamp: Long = System.currentTimeMillis(),
  val status: String = "Pending Review"
)
