package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.AppDatabase
import com.example.data.Inquiry
import com.example.model.DemoConcept
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface FormUiState {
  object Idle : FormUiState
  object Submitting : FormUiState
  data class Success(val inquiry: Inquiry) : FormUiState
  data class Error(val message: String) : FormUiState
}

class MainViewModel(application: Application) : AndroidViewModel(application) {
  private val database = AppDatabase.getDatabase(application)
  private val inquiryDao = database.inquiryDao()

  val recentInquiries = inquiryDao.getAllInquiries()

  private val _formState = MutableStateFlow<FormUiState>(FormUiState.Idle)
  val formState: StateFlow<FormUiState> = _formState.asStateFlow()

  private val _selectedConcept = MutableStateFlow<DemoConcept?>(null)
  val selectedConcept: StateFlow<DemoConcept?> = _selectedConcept.asStateFlow()

  fun selectConcept(concept: DemoConcept?) {
    _selectedConcept.value = concept
  }

  fun submitInquiry(
    name: String,
    businessName: String,
    phoneNumber: String,
    businessType: String,
    websiteNeeded: String,
    message: String,
    onSuccess: (Inquiry) -> Unit
  ) {
    if (name.isBlank() || phoneNumber.isBlank()) {
      _formState.value = FormUiState.Error("Please provide your name and phone number.")
      return
    }

    viewModelScope.launch {
      _formState.value = FormUiState.Submitting
      try {
        val inquiry = Inquiry(
          name = name.trim(),
          businessName = businessName.trim().ifEmpty { "Not specified" },
          phoneNumber = phoneNumber.trim(),
          businessType = businessType.trim().ifEmpty { "General Business" },
          websiteNeeded = websiteNeeded.trim().ifEmpty { "Standard Website" },
          message = message.trim().ifEmpty { "Requested consultation" }
        )
        val id = inquiryDao.insertInquiry(inquiry)
        val saved = inquiry.copy(id = id)
        _formState.value = FormUiState.Success(saved)
        onSuccess(saved)
      } catch (e: Exception) {
        _formState.value = FormUiState.Error(e.localizedMessage ?: "Failed to save request.")
      }
    }
  }

  fun resetFormState() {
    _formState.value = FormUiState.Idle
  }
}
