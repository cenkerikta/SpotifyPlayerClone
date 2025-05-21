package com.example.spotifyclone.ui.theme

import android.view.View
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SpecializedButton(icon: Int, size: Int, color: Color) {
    Button(
        onClick = { },
        modifier = Modifier.size(size.dp), // Butonun boyutunu belirle
        contentPadding = PaddingValues(4.dp), // İç boşluk yok
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Icon",
            modifier = Modifier.fillMaxSize(), // İkon butonu tamamen kapsar
            tint = color
        )
    }
}