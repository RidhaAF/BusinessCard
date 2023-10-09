package com.ridhaaf.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ridhaaf.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileCard() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        val image = painterResource(R.drawable.img_profile_photo)

        Image(
            painter = image,
            contentDescription = stringResource(R.string.profile_photo_desc),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = stringResource(R.string.full_name),
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.role),
            color = Color(0xFF4d5d53),
            fontStyle = FontStyle.Italic,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun ContactIcon(
    icon: ImageVector, contentDescription: String,
) {
    Icon(
        icon,
        contentDescription = contentDescription,
        tint = Color(0xFF4d5d53),
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
fun ContactInfoText(title: String) {
    Text(
        text = title,
        color = Color.White,
        modifier = Modifier.padding(8.dp),
    )
}

@Composable
fun ContactCard() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            ContactIcon(
                icon = Icons.Rounded.Phone,
                contentDescription = stringResource(R.string.phone_number_desc),
            )
            ContactIcon(
                icon = Icons.Rounded.Share,
                contentDescription = stringResource(R.string.website_desc),
            )
            ContactIcon(
                icon = Icons.Rounded.Email,
                contentDescription = stringResource(R.string.email_desc),
            )
        }
        Column {
            ContactInfoText(title = stringResource(R.string.phone_number))
            ContactInfoText(title = stringResource(R.string.website))
            ContactInfoText(title = stringResource(R.string.email))
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9AAB89))
            .padding(16.dp)
    ) {
        Spacer(Modifier.weight(1f))
        ProfileCard()
        Spacer(Modifier.weight(1f))
        ContactCard()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardScreen()
    }
}