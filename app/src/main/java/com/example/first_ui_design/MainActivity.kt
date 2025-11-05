package com.example.first_ui_design

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_ui_design.ui.theme.First_UI_DesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            First_UI_DesignTheme {
                NewsCardScreen()
            }
        }
    }
}

@Composable
fun NewsCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top image fills most of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.background_image),
                contentDescription = "News Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f))
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {

                Button(
                    onClick = { /* TODO: handle click */ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0x80FFA500) // semi-transparent orange
                    ),
                    border = BorderStroke(2.dp, Color(0xFFFFA500)), // light orange border
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "TECH",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))


                Text(
                    text = "The Future of Urban Living",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 36.sp
                )

                Spacer(modifier = Modifier.height(12.dp))


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Author",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("Sarah Chen", color = Color.White, fontSize = 18.sp)

                    Spacer(modifier = Modifier.width(16.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.schedule),
                        contentDescription = "Read time",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text("8 min read", color = Color.White, fontSize = 18.sp)
                }
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .height(100.dp)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomButtonWithIcon("News", R.drawable.article)
            BottomButtonWithIcon("Promos", R.drawable.promos)
            BottomButtonWithIcon("Settings", R.drawable.settings)
        }
    }
}

@Composable
fun BottomButtonWithIcon(text: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, color = Color.White, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsCardScreen() {
    First_UI_DesignTheme {
        NewsCardScreen()
    }
}
