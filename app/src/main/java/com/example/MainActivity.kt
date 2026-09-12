package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.data.Inquiry
import com.example.model.DemoConcept
import com.example.model.PricingPackage
import com.example.model.ServiceItem
import com.example.ui.FormUiState
import com.example.ui.MainViewModel
import com.example.ui.components.ConceptDetailDialog
import com.example.ui.components.ContactAndFinalCtaSection
import com.example.ui.components.FaqSection
import com.example.ui.components.FloatingWhatsAppButton
import com.example.ui.components.FooterSection
import com.example.ui.components.HeroSection
import com.example.ui.components.InquirySuccessDialog
import com.example.ui.components.PayAfterSection
import com.example.ui.components.PortfolioSection
import com.example.ui.components.PricingSection
import com.example.ui.components.ReviewsAndIndustriesSection
import com.example.ui.components.ServicesSection
import com.example.ui.components.TopNav
import com.example.ui.components.TrustStrip
import com.example.ui.components.WhyUsAndProcessSection
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.theme.PureWhite
import com.example.util.WhatsAppHelper
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        BuildWebApp(viewModel = viewModel)
      }
    }
  }
}

@Composable
fun BuildWebApp(viewModel: MainViewModel) {
  val context = LocalContext.current
  val listState = rememberLazyListState()
  val coroutineScope = rememberCoroutineScope()
  val snackbarHostState = remember { SnackbarHostState() }

  val formState by viewModel.formState.collectAsState()
  val selectedConcept by viewModel.selectedConcept.collectAsState()

  fun scrollToSection(section: String) {
    val targetIndex = when (section) {
      "home" -> 0
      "services" -> 2
      "pay_after" -> 3
      "pricing" -> 4
      "portfolio" -> 5
      "why_us" -> 6
      "reviews", "industries" -> 7
      "faq" -> 8
      "contact" -> 9
      else -> 0
    }
    coroutineScope.launch {
      listState.animateScrollToItem(targetIndex)
    }
  }

  Scaffold(
    snackbarHost = { SnackbarHost(snackbarHostState) },
    topBar = {
      TopNav(
        onNavigateToSection = { section -> scrollToSection(section) },
        onOpenWhatsAppConsultation = {
          WhatsAppHelper.openWhatsApp(
            context,
            "Hello BuildWeb Kenya, I'd like to book a free website consultation."
          )
        },
        modifier = Modifier.statusBarsPadding()
      )
    },
    floatingActionButton = {
      FloatingWhatsAppButton(
        onClick = {
          WhatsAppHelper.openWhatsApp(
            context,
            "Hello BuildWeb Kenya, I'd like to discuss getting a website for my business."
          )
        },
        modifier = Modifier.navigationBarsPadding()
      )
    }
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(PureWhite)
        .padding(innerPadding)
    ) {
      LazyColumn(
        state = listState,
        modifier = Modifier
          .fillMaxSize()
          .widthIn(max = 760.dp)
          .align(Alignment.TopCenter)
      ) {
        // 0: Hero Section
        item(key = "hero") {
          HeroSection(
            onBookConsultation = {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to discuss getting a website for my business."
              )
            },
            onViewPricing = {
              scrollToSection("pricing")
            }
          )
        }

        // 1: Trust / Value Strip
        item(key = "trust_strip") {
          TrustStrip()
        }

        // 2: Services Section
        item(key = "services") {
          ServicesSection(
            onServiceInquire = { service: ServiceItem ->
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to inquire about ${service.title} for my business."
              )
            }
          )
        }

        // 3: Pay After You See It Section
        item(key = "pay_after") {
          PayAfterSection(
            onStartWebsite = {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to start my website with the Pay After You See It offer."
              )
            }
          )
        }

        // 4: Pricing Section
        item(key = "pricing") {
          PricingSection(
            onSelectPackage = { pkg: PricingPackage ->
              WhatsAppHelper.openWhatsApp(
                context,
                pkg.whatsappMessage
              )
            },
            onCustomQuoteRequest = {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I need a custom quote for my website project."
              )
            }
          )
        }

        // 5: Portfolio / Demo Concepts Section
        item(key = "portfolio") {
          PortfolioSection(
            onSelectConcept = { concept: DemoConcept ->
              viewModel.selectConcept(concept)
            },
            onRequestConcept = { concept: DemoConcept ->
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'm interested in a website like the ${concept.industry} demo concept: ${concept.title}."
              )
            }
          )
        }

        // 6: Why Us & How It Works Process
        item(key = "why_us") {
          WhyUsAndProcessSection(
            onBuildMyWebsite = {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to build my website with your team."
              )
            }
          )
        }

        // 7: Reviews & Industries Section
        item(key = "reviews_industries") {
          ReviewsAndIndustriesSection(
            onContactUs = {
              scrollToSection("contact")
            },
            onIndustrySelected = { industry ->
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I run a business in ${industry.name} and would like a website."
              )
            }
          )
        }

        // 8: FAQ Section
        item(key = "faq") {
          FaqSection()
        }

        // 9: Contact & Final CTA Section
        item(key = "contact") {
          ContactAndFinalCtaSection(
            formState = formState,
            onSubmitRequest = { name, bizName, phone, type, needed, msg ->
              viewModel.submitInquiry(
                name = name,
                businessName = bizName,
                phoneNumber = phone,
                businessType = type,
                websiteNeeded = needed,
                message = msg,
                onSuccess = {
                  coroutineScope.launch {
                    snackbarHostState.showSnackbar("Your request has been received!")
                  }
                }
              )
            },
            onBookConsultation = {
              WhatsAppHelper.openWhatsApp(
                context,
                "Hello BuildWeb Kenya, I'd like to book a free website consultation."
              )
            },
            onViewPricing = {
              scrollToSection("pricing")
            }
          )
        }

        // 10: Footer Section
        item(key = "footer") {
          FooterSection(
            onNavigateToSection = { section -> scrollToSection(section) }
          )
        }
      }
    }
  }

  // Demo Concept Dialog
  selectedConcept?.let { concept ->
    ConceptDetailDialog(
      concept = concept,
      onDismiss = { viewModel.selectConcept(null) },
      onRequestThisConcept = { reqConcept ->
        WhatsAppHelper.openWhatsApp(
          context,
          "Hello BuildWeb Kenya, I'm interested in a website like the ${reqConcept.industry} demo concept: ${reqConcept.title}."
        )
      }
    )
  }

  // Inquiry Success Dialog
  if (formState is FormUiState.Success) {
    val inquiry = (formState as FormUiState.Success).inquiry
    InquirySuccessDialog(
      inquiry = inquiry,
      onDismiss = { viewModel.resetFormState() },
      onOpenWhatsAppWithDetails = { inq: Inquiry ->
        val details = "Hello BuildWeb Kenya, I submitted a website proposal request:%0A" +
            "• Name: ${inq.name}%0A" +
            "• Business: ${inq.businessName}%0A" +
            "• Phone: ${inq.phoneNumber}%0A" +
            "• Type: ${inq.businessType}%0A" +
            "• Package: ${inq.websiteNeeded}%0A" +
            "• Message: ${inq.message}"
        WhatsAppHelper.openWhatsApp(context, details)
        viewModel.resetFormState()
      }
    )
  }
}
