package com.example.weatherapp

//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import com.example.weatherapp.screens.ForecastScreen
//import com.example.weatherapp.screens.WeatherForecastViewModel
//import com.example.weatherapp.ui.theme.WeatherAppTheme
//import dagger.hilt.android.testing.HiltAndroidRule
//import org.junit.Assert.*
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//
///**
// * Instrumented test, which will execute on an Android device.
// *
// * See [testing documentation](http://d.android.com/tools/testing).
// */
//@RunWith(AndroidJUnit4::class)
//class ForeCastScreenTest {
//
//    @get:Rule
//    val hiltRule = HiltAndroidRule(this)
//
//    @get:Rule
//    val rule = createAndroidComposeRule<MainActivity>()
//
//    @Before
//    fun init(){
//        hiltRule.inject()
//    }
//
//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//
//       rule.setContent {
//           WeatherAppTheme() {
//               ForecastScreen() }
//           }
//
//    }
//}