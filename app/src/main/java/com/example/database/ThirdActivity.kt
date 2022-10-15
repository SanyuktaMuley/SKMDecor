package com.example.database

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.database.ui.theme.DataBaseTheme


//import com.example.retailapp.ui.theme.RetailAppTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataBaseTheme{
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Headings1(LocalContext.current)

                    ImgAndAdd2(LocalContext.current)
                    toCart1(LocalContext.current)

                }
            }

        }
    }
}
@Composable
fun Headings1(context: Context){
    Column(Modifier.padding(60.dp,15.dp,2.dp,0.dp),verticalArrangement = Arrangement.Top,horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Some more to take away!",
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
fun ImgAndAdd2(context: Context) {

    Row{
        Column(Modifier.padding(2.dp,60.dp,2.dp,10.dp)){
            /////////////////////////////
            val imageModifier = Modifier.size(165.dp).padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier
            )
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Candle Holder Rs.200",
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
                        text = "Adore your side table with candles!Golden Vibes that they brings!",
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
                    "Candle Holder"
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
            val imageModifier1 = Modifier.size(165.dp).padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier1
            )
            //text
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Water Lamps Rs.300",
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
                        text = "Water Lamps to make your life as they are!Make your House party special!",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            val mContext2=LocalContext.current
           // var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Water Lamps"
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
        Column(Modifier.padding(2.dp,60.dp,2.dp,10.dp))
        {
            /////////////////////////////
            //image
            val imageModifier1 = Modifier.size(165.dp).padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image4),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier1
            )
            //text
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Stand Swing Rs.8000",
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
                        text = "Swing cum Seater that fills the corner for you to relax!",
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
                    "Stand Swing"
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
            val imageModifier2 = Modifier.size(165.dp).padding(10.dp)
                .border(BorderStroke(1.dp, Color.Black))

            Image(
                painter = painterResource(id = R.drawable.image3),
                contentDescription = "fjgefge",
                contentScale = ContentScale.Fit,
                modifier = imageModifier2
            )
            //text
            //////
            Column(Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    "Wall Holders Rs.2000",
                    Modifier.padding(10.dp,2.dp,2.dp,2.dp),
                    textAlign = TextAlign.Center,
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp),
                    fontWeight = FontWeight.Bold,
                )

                Box(modifier = Modifier
                    .width(170.dp)
                    .height(80.dp)
                    .background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Desolated wall of your living room calls you ! Beautify her with these holders!",
                        color=Color.White,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            //////
            val mContext3=LocalContext.current
          //  var dbHandler: DBHandler = DBHandler(context)

            Button(onClick = {
                dbHandler.addNewCourse(
                    "Wall Holders"
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
    }

}
@Composable
fun toCart1(context: Context){
    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start) {

        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, ViewCourses::class.java))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        ) {
            Text("View Cart",color=Color.White)
        }
    }
}


