package com.example.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Construction
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Dns
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.HealthAndSafety
import androidx.compose.material.icons.filled.Hotel
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocalHospital
import androidx.compose.material.icons.filled.LocalPhone
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.NearMe
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Policy
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.graphics.vector.ImageVector

data class ServiceItem(
  val id: String,
  val title: String,
  val description: String,
  val icon: ImageVector,
  val tag: String
)

data class PricingPackage(
  val id: String,
  val name: String,
  val priceDisplay: String,
  val rawPrice: Int,
  val isPopular: Boolean,
  val targetAudience: String,
  val features: List<String>,
  val ctaText: String,
  val whatsappMessage: String
)

data class DemoConcept(
  val id: String,
  val industry: String,
  val title: String,
  val tagline: String,
  val keyFeatures: List<String>,
  val heroColorHex: Long,
  val suitableFor: String,
  val sampleModules: List<String>
)

data class FaqItem(
  val question: String,
  val answer: String
)

data class WhyUsItem(
  val title: String,
  val description: String,
  val icon: ImageVector
)

data class ProcessStep(
  val stepNumber: String,
  val title: String,
  val description: String,
  val highlight: String = ""
)

data class TrustItem(
  val title: String,
  val subtitle: String,
  val icon: ImageVector
)

data class IndustryCategory(
  val name: String,
  val icon: ImageVector
)

object BuildWebData {
  val trustItems = listOf(
    TrustItem(
      title = "Affordable Pricing",
      subtitle = "Professional websites without agency-level prices.",
      icon = Icons.Default.Sell
    ),
    TrustItem(
      title = "Mobile Friendly",
      subtitle = "Your website looks great on phones, tablets and computers.",
      icon = Icons.Default.PhoneAndroid
    ),
    TrustItem(
      title = "Built for Business",
      subtitle = "Designed to help customers find, contact and buy from you.",
      icon = Icons.Default.Business
    ),
    TrustItem(
      title = "Pay After You See It",
      subtitle = "We build your website before you pay.",
      icon = Icons.Default.Visibility
    )
  )

  val services = listOf(
    ServiceItem(
      id = "biz_web",
      title = "Business Websites",
      description = "Professional websites that establish credibility and help customers discover your business.",
      icon = Icons.Default.Business,
      tag = "Popular"
    ),
    ServiceItem(
      id = "landing_pages",
      title = "Landing Pages",
      description = "High-converting pages designed around a specific service, product or campaign.",
      icon = Icons.Default.NearMe,
      tag = "High Conversion"
    ),
    ServiceItem(
      id = "ecommerce",
      title = "E-Commerce Websites",
      description = "Online stores where customers can browse products and make purchases.",
      icon = Icons.Default.ShoppingCart,
      tag = "Online Sales"
    ),
    ServiceItem(
      id = "redesign",
      title = "Website Redesign",
      description = "Transform an outdated website into a modern, professional digital experience.",
      icon = Icons.Default.DesignServices,
      tag = "Modernize"
    ),
    ServiceItem(
      id = "maintenance",
      title = "Website Maintenance",
      description = "Keep your website updated, secure and functioning properly.",
      icon = Icons.Default.Security,
      tag = "Peace of Mind"
    ),
    ServiceItem(
      id = "hosting",
      title = "Domain & Hosting",
      description = "Help businesses establish and maintain their professional online address.",
      icon = Icons.Default.Dns,
      tag = "Turnkey"
    ),
    ServiceItem(
      id = "booking",
      title = "Booking Systems",
      description = "Allow customers to conveniently book appointments, services or consultations online.",
      icon = Icons.Default.CheckCircle,
      tag = "Automate"
    ),
    ServiceItem(
      id = "whatsapp",
      title = "WhatsApp Integration",
      description = "Make it easy for visitors to contact your business directly through WhatsApp.",
      icon = Icons.Default.LocalPhone,
      tag = "Direct Sales"
    ),
    ServiceItem(
      id = "seo",
      title = "SEO",
      description = "Optimize websites so businesses have a better opportunity to be discovered through search engines.",
      icon = Icons.Default.Search,
      tag = "Google Rank"
    )
  )

  val pricingPackages = listOf(
    PricingPackage(
      id = "starter",
      name = "STARTER",
      priceDisplay = "KSh 10,000",
      rawPrice = 10000,
      isPopular = false,
      targetAudience = "For businesses that need a professional online presence.",
      features = listOf(
        "1–5 pages",
        "Mobile responsive design",
        "WhatsApp integration",
        "Contact form",
        "Basic SEO",
        "Professional design"
      ),
      ctaText = "Get Started",
      whatsappMessage = "Hello BuildWeb Kenya, I'm interested in your Starter website package (KSh 10,000)."
    ),
    PricingPackage(
      id = "business",
      name = "BUSINESS",
      priceDisplay = "KSh 20,000",
      rawPrice = 20000,
      isPopular = true,
      targetAudience = "For growing businesses that need more functionality.",
      features = listOf(
        "5–10 pages",
        "Everything in Starter",
        "Booking/inquiry system",
        "Google Maps integration",
        "Social media integration",
        "Advanced SEO"
      ),
      ctaText = "Choose Business",
      whatsappMessage = "Hello BuildWeb Kenya, I'm interested in your Business website package (KSh 20,000)."
    ),
    PricingPackage(
      id = "premium",
      name = "PREMIUM",
      priceDisplay = "KSh 35,000+",
      rawPrice = 35000,
      isPopular = false,
      targetAudience = "For businesses requiring advanced functionality.",
      features = listOf(
        "Custom website",
        "E-commerce / advanced functionality",
        "Payment integration",
        "Booking system",
        "Admin features",
        "Advanced SEO"
      ),
      ctaText = "Talk to Us",
      whatsappMessage = "Hello BuildWeb Kenya, I'm interested in your Premium website package (KSh 35,000+)."
    )
  )

  val payAfterSteps = listOf(
    ProcessStep(
      stepNumber = "01",
      title = "Tell Us About Your Business",
      description = "Contact us and explain what your business does and what you need."
    ),
    ProcessStep(
      stepNumber = "02",
      title = "We Build Your Website",
      description = "Our team creates a professional website concept tailored to your business."
    ),
    ProcessStep(
      stepNumber = "03",
      title = "You Approve & Pay",
      description = "If you love the website, make your payment and we finalize everything."
    )
  )

  val whyChooseUs = listOf(
    WhyUsItem(
      title = "Affordable",
      description = "Professional websites starting from just KSh 10,000.",
      icon = Icons.Default.Sell
    ),
    WhyUsItem(
      title = "Professional Design",
      description = "We create websites that make your business look credible and trustworthy.",
      icon = Icons.Default.CheckCircle
    ),
    WhyUsItem(
      title = "Mobile First",
      description = "Your customers are on their phones. Your website should be too.",
      icon = Icons.Default.PhoneAndroid
    ),
    WhyUsItem(
      title = "Business Focused",
      description = "We don't just build websites. We build websites designed around your customers and business goals.",
      icon = Icons.Default.Business
    ),
    WhyUsItem(
      title = "Transparent Pricing",
      description = "Know what you're paying for before we start.",
      icon = Icons.Default.CreditCard
    ),
    WhyUsItem(
      title = "Personal Support",
      description = "Customers can communicate directly with our team through WhatsApp.",
      icon = Icons.Default.SupportAgent
    )
  )

  val howItWorks = listOf(
    ProcessStep("01", "Contact Us", "Tell us about your business."),
    ProcessStep("02", "Discuss Your Needs", "We understand your business, customers and goals."),
    ProcessStep("03", "We Build", "We create your website."),
    ProcessStep("04", "You Review", "You see the completed website before payment."),
    ProcessStep("05", "Launch", "Once approved and paid for, your website goes live.")
  )

  val demoConcepts = listOf(
    DemoConcept(
      id = "demo_restaurant",
      industry = "Restaurant & Cafe",
      title = "Savanna Table & Grill",
      tagline = "Interactive food menu, table reservations & WhatsApp ordering",
      keyFeatures = listOf("Digital Food Menu", "Table Booking", "Direct WhatsApp Order", "Location & Hours"),
      heroColorHex = 0xFF991B1B,
      suitableFor = "Cafes, fine dining, bistros, bakeries, fast food joints",
      sampleModules = listOf("Menu with pricing", "Table reservation form", "Chef specials gallery", "Google Maps location")
    ),
    DemoConcept(
      id = "demo_salon",
      industry = "Salon & Barbershop",
      title = "Elegance Hair & Grooming",
      tagline = "Service catalogue, stylist booking & Instagram showcase",
      keyFeatures = listOf("Service Menu with Prices", "Appointment Scheduling", "Before/After Gallery", "Client Reviews"),
      heroColorHex = 0xFF701A75,
      suitableFor = "Beauty salons, executive barbershops, spas, nail bars",
      sampleModules = listOf("Stylist selection", "Treatment packages", "WhatsApp booking button", "Price list")
    ),
    DemoConcept(
      id = "demo_real_estate",
      industry = "Real Estate",
      title = "Kilimani Heights Property",
      tagline = "Property listings, filter by location & schedule viewing",
      keyFeatures = listOf("Property Showcase", "Virtual Viewing Request", "Neighborhood Guide", "Agent WhatsApp"),
      heroColorHex = 0xFF065F46,
      suitableFor = "Real estate agencies, property managers, land sellers",
      sampleModules = listOf("Filtered search (beds, price)", "High-res photo sliders", "Floorplans", "Inquiry form")
    ),
    DemoConcept(
      id = "demo_hotel",
      industry = "Hotel & Accommodation",
      title = "Serengeti Vista Lodge",
      tagline = "Room showcases, seasonal rates & instant booking inquiries",
      keyFeatures = listOf("Room Showcase", "Amenities Matrix", "Direct Booking Inquiries", "Airport Transfer Info"),
      heroColorHex = 0xFF1E3A8A,
      suitableFor = "Hotels, safari lodges, Airbnb hosts, guest houses, resorts",
      sampleModules = listOf("Room availability check", "Rates calculator", "Guest experience guide", "Dining highlights")
    ),
    DemoConcept(
      id = "demo_construction",
      industry = "Construction",
      title = "Apex Builders & Civil Works",
      tagline = "Project portfolios, tenders, equipment list & quote requests",
      keyFeatures = listOf("Completed Projects", "Equipment Capabilities", "Safety Certifications", "Request a Quote"),
      heroColorHex = 0xFFB45309,
      suitableFor = "General contractors, architects, civil engineers, interior fit-outs",
      sampleModules = listOf("Case studies with photos", "Service capabilities", "Corporate PDF download", "Request bid")
    ),
    DemoConcept(
      id = "demo_ecommerce",
      industry = "E-Commerce",
      title = "Nairobi Trends Store",
      tagline = "Product catalog, cart system & M-Pesa ready checkout",
      keyFeatures = listOf("Catalog with Filters", "Product Search", "M-Pesa / Card Ready", "Order Tracking"),
      heroColorHex = 0xFF0D9488,
      suitableFor = "Boutiques, electronics retailers, cosmetics, footwear, grocery",
      sampleModules = listOf("Category grid", "Fast checkout", "WhatsApp order assist", "Stock badges")
    ),
    DemoConcept(
      id = "demo_pro_services",
      industry = "Professional Services",
      title = "Apex Legal & Advisory",
      tagline = "Practice areas, consultant profiles & consultation calendar",
      keyFeatures = listOf("Practice Areas", "Attorney/Partner Profiles", "Case Highlights", "Book Consultation"),
      heroColorHex = 0xFF1E293B,
      suitableFor = "Law firms, accounting practices, business consultants, auditors",
      sampleModules = listOf("Free assessment form", "Consultant bios", "Publications/Articles", "Office locator")
    ),
    DemoConcept(
      id = "demo_gym",
      industry = "Fitness / Gym",
      title = "Pulse Fitness & Wellness",
      tagline = "Class timetable, personal trainer profiles & membership plans",
      keyFeatures = listOf("Weekly Class Schedule", "Membership Tiers", "Trainer Profiles", "Free Trial Pass"),
      heroColorHex = 0xFFDC2626,
      suitableFor = "Gyms, CrossFit boxes, yoga studios, personal trainers",
      sampleModules = listOf("1-Day Free pass signup", "Membership pricing cards", "Class schedule table", "Virtual tour")
    )
  )

  val industries = listOf(
    IndustryCategory("Restaurants", Icons.Default.Restaurant),
    IndustryCategory("Salons & Barbershops", Icons.Default.ContentCut),
    IndustryCategory("Hotels & Accommodation", Icons.Default.Hotel),
    IndustryCategory("Real Estate", Icons.Default.Apartment),
    IndustryCategory("Construction", Icons.Default.Construction),
    IndustryCategory("Retail Shops", Icons.Default.Store),
    IndustryCategory("E-commerce", Icons.Default.ShoppingCart),
    IndustryCategory("Clinics", Icons.Default.LocalHospital),
    IndustryCategory("Gyms", Icons.Default.FitnessCenter),
    IndustryCategory("Schools", Icons.Default.School),
    IndustryCategory("Professional Services", Icons.Default.Policy),
    IndustryCategory("Startups", Icons.Default.Speed),
    IndustryCategory("Local Businesses", Icons.Default.Store),
    IndustryCategory("Service Businesses", Icons.Default.DesignServices)
  )

  val faqs = listOf(
    FaqItem(
      question = "How much does a website cost?",
      answer = "Our websites start from KSh 10,000, with packages available for growing businesses and businesses requiring advanced functionality."
    ),
    FaqItem(
      question = "Do I have to pay before seeing the website?",
      answer = "No. We build your website before you pay. You get to see what we've prepared before making your final payment."
    ),
    FaqItem(
      question = "How do I get started?",
      answer = "Click Book a Free Consultation and contact us through WhatsApp."
    ),
    FaqItem(
      question = "Do you build e-commerce websites?",
      answer = "Yes. We build e-commerce websites for businesses that want to sell products online."
    ),
    FaqItem(
      question = "Can you redesign my existing website?",
      answer = "Yes. We can modernize and improve an existing website."
    ),
    FaqItem(
      question = "Do you provide hosting and domains?",
      answer = "Yes. We can help businesses with domain and hosting setup."
    ),
    FaqItem(
      question = "Can customers contact my business through WhatsApp?",
      answer = "Yes. WhatsApp integration is available."
    ),
    FaqItem(
      question = "Do you build booking systems?",
      answer = "Yes. Booking and inquiry systems are available depending on the package and business requirements."
    ),
    FaqItem(
      question = "Do you work with businesses outside Nairobi?",
      answer = "Yes. BuildWeb Kenya can work with businesses throughout Kenya remotely."
    )
  )
}
