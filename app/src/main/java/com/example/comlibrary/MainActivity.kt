package com.example.comlibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.example.comlibrary.ui.theme.AppColors
import com.example.comlibrary.ui.theme.ComLibraryTheme
import com.example.comlibrary.ui.theme.LocalAppColors
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

// App entry point
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComLibraryTheme(brand = "brandReliant", darkTheme = false) {
                ExampleScreen()
            }
        }
    }
}

@Composable
fun ExampleScreen() {
    val colors = LocalAppColors.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.primaryBase)
            .padding(16.dp)
    ) {
        Text(
            text = "Primary Color",
            modifier = Modifier
                .background(colors.primaryBase)
                .border(1.dp, colors.secondaryBase)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Secondary Color",
            modifier = Modifier
                .background(colors.secondaryBase)
                .border(1.dp, colors.tertiaryBase)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewExampleScreen() {
    val mockColors = AppColors(
        primaryBase = Color(0xFF6200EE),
        secondaryBase = Color(0xFF03DAC5),
        tertiaryBase = Color(0xFFBB86FC)
    )
    CompositionLocalProvider(LocalAppColors provides mockColors) {
        ComLibraryTheme(brand = "brandDE", darkTheme = false) {
            ExampleScreen()
        }
    }
}

//package com.example.comlibrary
//
//import android.content.Context
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.comlibrary.ui.theme.AppTheme
//import com.example.comlibrary.ui.theme.LocalAppColors
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.platform.LocalContext
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AppTheme(context = this, brand = "brandReliant", isDarkTheme = false) {
//                ExampleScreen()
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun ExampleScreen() {
//    val colors = LocalAppColors.current
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(colors.primaryBase)
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Primary Color",
//            modifier = Modifier
//                .background(colors.primaryBase)
//                .border(1.dp, colors.secondaryBase)
//                .padding(8.dp)
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(
//            text = "Secondary Color",
//            modifier = Modifier
//                .background(colors.secondaryBase)
//                .border(1.dp, colors.tertiaryBase)
//                .padding(8.dp)
//        )
//    }
//}
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewExampleScreen() {
//    val context = LocalContext.current
//    AppTheme(context = context, brand = "brandReliant", isDarkTheme = false) {
//        ExampleScreen()
//    }
//}

/////////////

//@Preview(showBackground = true)
//@Composable
//fun PreviewExampleScreen() {
//    AppTheme(context = null, brand = "brandReliant", isDarkTheme = false) {
//        ExampleScreen()
//    }
//}

//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.comlibrary.ui.theme.ComLibraryTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            ComLibraryTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComLibraryTheme {
//        Greeting("Android")
//    }
//}