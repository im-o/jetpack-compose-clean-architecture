package id.barakkastudio.nebenginaja.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import id.barakkastudio.core.ui.theme.JetShopeeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetShopeeTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(this)
                    JetMainApp(windowSize = windowSize.widthSizeClass)
                }
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetShopeePreview() {
    JetShopeeTheme {
        Surface {
            JetMainApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}