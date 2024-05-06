package com.test.actitivies

import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.core.graphics.drawable.toBitmap
import com.test.actitivies.ui.theme.MainActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityTheme {
                val face =
                    AppCompatResources.getDrawable(LocalContext.current, R.drawable.default_user)
                        ?.toBitmap()
                ImageTest(
                    bitmap = face!!,
                )
            }
        }
    }
}

@Composable
private fun ImageTest(bitmap: Bitmap) {
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Face",
        modifier = Modifier.clickable(role = Role.Image) { }
    )
}