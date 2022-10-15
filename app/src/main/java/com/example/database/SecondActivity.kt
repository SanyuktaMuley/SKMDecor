package com.example.database

import android.R.attr.fontFamily
import android.R.attr.textSize
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.database.ui.theme.*


class SecondActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            DataBaseTheme{
                // A surface container using the 'background' color from the theme
                Headings(LocalContext.current)
                MyContent1(LocalContext.current)
                ImgAndAdd(LocalContext.current)
                toCart(LocalContext.current)

            }

        }
    }
}
@Composable
fun Headings(context: Context){
    Column(Modifier.padding(15.dp,15.dp,2.dp,0.dp),verticalArrangement = Arrangement.Top,horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Amazing Ideas for your Sweet Home!",
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 18.sp,
                shadow = Shadow(
                    color = Color.Black,
                )
            ),
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Italic
        )
    }

}
@Composable
fun MyContent1(context: Context){

    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {

        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, ThirdActivity::class.java))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        ) {
            Text("Next>>",color= Color.White)
        }
    }
}
@Composable
fun ImgAndAdd(context: Context) {

    Row{
        Column(Modifier.padding(2.dp,60.dp,2.dp,10.dp)){
            /////////////////////////////
            val imageModifier = Modifier
                .size(165.dp)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image7),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )
            ///////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Sphery Light Rs.200",
                    Modifier.padding(10.dp,2.dp,2.dp,2.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Box(modifier = Modifier
                    .width(170.dp)
                    .height(80.dp)
                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Night light it is! Serve it with your candle lights dine or have it as your night lantern.",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            val mContext1=LocalContext.current
            var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Sphery Light"
                )
                Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
//                mContext1.startActivity(Intent(mContext1, ThirdActivity::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("ADD +",color=Color.White)
            }
            //////////////////////////////
            //image
            val imageModifier1 = Modifier
                .size(165.dp)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image10),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier1
            )
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Face Abstracts Rs.2500",
                    Modifier.padding(2.dp,2.dp,2.dp,2.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Box(modifier = Modifier
                    .width(170.dp)
                    .height(80.dp)
                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Be it white ,yellow or orange walls these abstracts will show there presence!",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            //text
            //var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Face Abstracts"
                )
                Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
//                mContext1.startActivity(Intent(mContext1, ThirdActivity::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("ADD +",color=Color.White)
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Column(Modifier.padding(2.dp,60.dp,2.dp,10.dp))
        {
            /////////////////////////////
            //image
            val imageModifier1 = Modifier
                .size(165.dp)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image8),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier1
            )
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Wooden shelf Rs.1000",
                    Modifier.padding(10.dp,2.dp,2.dp,2.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Box(modifier = Modifier
                    .width(170.dp)
                    .height(80.dp)
                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Besides your Balcony,Pots,Frames,Plants and memories reside!",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            //text

            val mContext1=LocalContext.current
            var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Wooden shelf"
                )
                Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
//                mContext1.startActivity(Intent(mContext1, ThirdActivity::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("ADD +",color=Color.White)
            }


            //////////////////////////////////////////
            //image
            val imageModifier3 = Modifier
                .size(165.dp)
                .padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image12),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier3
            )
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Ceiling Lights Rs.550",
                    Modifier.padding(15.dp,2.dp,2.dp,2.dp),
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )

                Box(modifier = Modifier
                    .width(170.dp)
                    .height(80.dp)
                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Dreamy nights with serene Lights! Fills your Bedroom with bliss!",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            //text

            val mContext3=LocalContext.current

            //var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Ceiling Lights"
                )
                Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
//                mContext1.startActivity(Intent(mContext1, ThirdActivity::class.java))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("ADD +",color=Color.White)
            }
            /////////////////////////////
        }
    }

}
@Composable
fun toCart(context: Context){
    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start) {

        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, ViewCourses::class.java))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        ) {
            Text("View Cart",color= Color.White)
        }
    }
}

