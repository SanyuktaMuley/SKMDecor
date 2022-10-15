package com.example.database

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.database.ui.theme.DataBaseTheme
import com.example.database.ui.theme.greenColor

class FourthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataBaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    Scaffold(// specifying top bar.
                        topBar = { TopAppBar(backgroundColor = greenColor,title = {Text(text = "Customer Care Directory",color = Color.White, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center,) }) }
                    )
                    {
                        openDialer()
                    }
                }
            }
        }
    }
}


@Composable
fun openDialer() {

    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.TopCenter
    )
    {
        Text(
            "" +
                    "=============================\r\n\r\nDinesh: 1234567890\r\n\r\nNinad: 1020345678\r\n\r\nJuhi: 9876054321\r\n\r\nHema: 9023456864\r\n\r\n=============================",
            Modifier.padding(50.dp),
        )
    }

    val phoneNumber = remember {
        mutableStateOf(TextFieldValue())
    }

    val ctx = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        TextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            placeholder = { Text(text = "Enter your phone number") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val u = Uri.parse("tel:" + phoneNumber.value.text)
            val i = Intent(Intent.ACTION_DIAL, u)
            try {

                ctx.startActivity(i)
            } catch (s: SecurityException) {

                Toast.makeText(ctx, "An error occurred", Toast.LENGTH_LONG)
                    .show()
            }


        })
        {
            Text(
                text = "Dial",
                modifier = Modifier.padding(10.dp),
                color = Color.White,
                fontSize = 15.sp
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.BottomStart
    )
    {
        Text(
            "\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\r\rTHANKYOU!!\r\n\r\n",
            Modifier.padding(70.dp),
        )
        Text(
            "\r\nHOPE YOU HAD A GOOD EXPERIANCE WITH APP:)\r\n\r\n\r\n",
            Modifier.padding(10.dp),
        )

    }

}

