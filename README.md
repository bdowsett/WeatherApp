# WeatherApp

## Description 
Small Android app using Compose, Hilt, Retrofit, Expresso, Coroutines

App returns 7 weather Forecast for London and allows user to click on a list item and see further weather info

![image](https://github.com/bdowsett/WeatherApp/assets/85438016/26333e03-8225-4b88-9a02-db70f6202687)
![image](https://github.com/bdowsett/WeatherApp/assets/85438016/e73e86d8-2c0f-4a5e-8cd8-726f455a99b2)

For simplicity I have hardcoded the Api call with the queries London and 7 days. 

To run the app you will need to create an account at https://www.weatherapi.com and retrieve an api_key, the key can then be placed in the Constants object within the common package

`object Constants {
    const val API_KEY = ""
}`

## Project Structure

```├── README.md
├── app
│   ├── build.gradle
│   ├── libs
│   ├── proguard-rules.pro
│   └── src
│       ├── androidTest
│       │   └── java
│       │       └── com
│       │           └── example
│       │               └── weatherapp
│       │                   └── ForeCastScreenTest.kt
│       ├── main
│       │   ├── AndroidManifest.xml
│       │   ├── java
│       │   │   └── com
│       │   │       └── example
│       │   │           └── weatherapp
│       │   │               ├── MainActivity.kt
│       │   │               ├── WeatherApplication.kt
│       │   │               ├── common
│       │   │               │   └── Constants.kt
│       │   │               ├── data
│       │   │               │   ├── WeatherApi.kt
│       │   │               │   ├── WeatherRepositoryImpl.kt
│       │   │               │   └── model
│       │   │               │       └── WeatherData.kt
│       │   │               ├── di
│       │   │               │   └── AppModule.kt
│       │   │               ├── navigation
│       │   │               │   ├── NavGraph.kt
│       │   │               │   └── Screen.kt
│       │   │               ├── repository
│       │   │               │   └── WeatherRepository.kt
│       │   │               ├── screens
│       │   │               │   ├── ForecastScreen.kt
│       │   │               │   ├── WeatherDetailScreen.kt
│       │   │               │   └── WeatherForecastViewModel.kt
│       │   │               ├── ui
│       │   │               │   └── theme
│       │   │               │       ├── Color.kt
│       │   │               │       ├── Theme.kt
│       │   │               │       └── Type.kt
│       │   │               └── util
│       │   │                   ├── DateProvider.kt
│       │   │                   └── ForecastScreenState.kt
│       │   └── res
│       │       ├── drawable
│       │       │   └── ic_launcher_background.xml
│       │       ├── drawable-v24
│       │       │   └── ic_launcher_foreground.xml
│       │       ├── layout
│       │       │   └── activity_main.xml
│       │       ├── mipmap-anydpi-v26
│       │       │   ├── ic_launcher.xml
│       │       │   └── ic_launcher_round.xml
│       │       ├── mipmap-hdpi
│       │       │   ├── ic_launcher.webp
│       │       │   └── ic_launcher_round.webp
│       │       ├── mipmap-mdpi
│       │       │   ├── ic_launcher.webp
│       │       │   └── ic_launcher_round.webp
│       │       ├── mipmap-xhdpi
│       │       │   ├── ic_launcher.webp
│       │       │   └── ic_launcher_round.webp
│       │       ├── mipmap-xxhdpi
│       │       │   ├── ic_launcher.webp
│       │       │   └── ic_launcher_round.webp
│       │       ├── mipmap-xxxhdpi
│       │       │   ├── ic_launcher.webp
│       │       │   └── ic_launcher_round.webp
│       │       ├── values
│       │       │   ├── colors.xml
│       │       │   ├── font_certs.xml
│       │       │   ├── strings.xml
│       │       │   └── themes.xml
│       │       └── xml
│       │           ├── backup_rules.xml
│       │           └── data_extraction_rules.xml
│       └── test
│           └── java
│               └── com
│                   └── example
│                       └── weatherapp
│                           ├── DayAndDateProviderTest.kt
│                           ├── WeatherForecastViewModelTest.kt
│                           └── testutils
│                               ├── CoroutinesTestRule.kt
│                               └── MockWeatherData.kt
├── build.gradle
├── file_tree.txt
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
├── local.properties
└── settings.gradle```



