package com.example.myapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {

            }
                logo()
                logoPreview()
            }



        }
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun logo() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement=Arrangement.Center,
        horizontalAlignment=Alignment.CenterHorizontally) {
        var text by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var context = LocalContext.current
        Image(
            painter = painterResource(id = R.drawable.pngwing), contentDescription = "Login Image",
            modifier = Modifier
                .size(100.dp)
                .padding(10.dp)
        )

        Text(
            text = "Welcome", modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        OutlinedTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = {
                Text(text = "Username")
            },
            maxLines = 2,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon"
                    )
                }

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            )

        )
        OutlinedTextField(
            value = password,
            onValueChange = { newText -> password = newText },
            label = {
                Text(text = "Password")
            },
            maxLines = 2,
            leadingIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password Icon"
                    )
                }

            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Go
            )
        )
        Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id =R.drawable.amazon),contentDescription = "Amazon",
                modifier= Modifier
                    .size(90.dp)
                    .padding(10.dp))

            Button(
                onClick = {
                    val url = "https://www.amazon.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, "No web browser available", Toast.LENGTH_LONG)
                            .show()
                    }
                },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Open Amazon")
            }
        }
        Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id =R.drawable.flipkart),contentDescription = "Flipkart",
                modifier=Modifier.size(100.dp))

            Button(
                onClick = {
                    val url = "https://www.flipkart.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, "No web browser available", Toast.LENGTH_LONG)
                            .show()
                    }
                },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Open Flipkart")
            }
        }
        Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id =R.drawable.myntra),contentDescription = "Myntra",
                modifier= Modifier
                    .size(90.dp)
                    .padding(10.dp))

            Button(
                onClick = {
                    val url = "https://www.myntra.com"
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

                    if (intent.resolveActivity(context.packageManager) != null) {
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, "No web browser available", Toast.LENGTH_LONG)
                            .show()
                    }
                },
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
                Text(text = "Open Myntra")
            }
        }

    }
}

@Preview
@Composable
fun logoPreview(){
    logo()
}

