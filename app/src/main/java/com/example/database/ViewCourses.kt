package com.example.database

import android.app.Activity
import com.example.database.ui.theme.greenColor
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.database.ui.theme.DataBaseTheme

class ViewCourses : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                        readDataFromDatabase(LocalContext.current)
                        delete(LocalContext.current)
                        callfourth(LocalContext.current)
                    }
    }
}
@Composable
fun readDataFromDatabase(context: Context) {
    lateinit var courseList: List<CourseModel>
    courseList = ArrayList<CourseModel>()

    val dbHandler: DBHandler = DBHandler(context);
    courseList = dbHandler.readCourses()!!
    LazyColumn {
        itemsIndexed(courseList) { index, item ->
            Card(
                modifier = Modifier.padding(8.dp),

                elevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Item ID : " + courseList[index].ID,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(

                        text = courseList[index].courseName,
                        modifier = Modifier.padding(4.dp),
                        color = Color.Black, textAlign = TextAlign.Center
                    )
                    // on below line inside row we are adding spacer
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}


@Composable
fun delete(
    context: Context
) {

    val activity = context as Activity
    val courseName = remember {
        mutableStateOf(TextFieldValue())
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {

        var dbHandler: DBHandler = DBHandler(context)
//
//        Text(
//            text = "Enter name to delete",
//            color = greenColor, fontSize = 8.sp
//        )

        Spacer(modifier = Modifier.height(30.dp))

        TextField(
            value = courseName.value,
            onValueChange = { courseName.value = it },
            placeholder = { Text(text = "Enter item name to delete", fontSize = 10.sp) },
            modifier = Modifier
                .fillMaxWidth()
                .width(100.dp)
                .height(55.dp),

            textStyle = TextStyle(color = Color.Black, fontSize = 3.sp),
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            dbHandler.deleteCourse(
                courseName.value.text,
            )
            Toast.makeText(context, "Course Deleted from Database", Toast.LENGTH_SHORT).show()
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),

            ) {
            Text(text = "Delete item from cart", color = Color.White, fontSize = 8.sp)
        }
        Spacer(modifier = Modifier.height(40.dp))


    }
}
@Composable
fun refresh(context: Context)
{
    Button(onClick = {

        Toast.makeText(context, "Reloading..", Toast.LENGTH_SHORT).show()
    }) {
        Text(text = "Refresh", color = Color.White)
    }
    Spacer(modifier = Modifier.height(95.dp))
}
@Composable
fun callfourth(context: Context){
    val mContext = LocalContext.current

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.Start) {

        Button(
            onClick = {
                mContext.startActivity(Intent(mContext, FourthActivity::class.java))
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Contact us",color=Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    DataBaseTheme{
        readDataFromDatabase(LocalContext.current)
        delete(LocalContext.current)
    }


}