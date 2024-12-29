package com.durranitech.ecomerceapp.presentation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.durranitech.ecomerceapp.R
import com.durranitech.ecomerceapp.ui.theme.EcomerceAppTheme
import com.durranitech.ecomerceapp.ui.theme.MyCustomColor

@Composable
fun Home() {
    EcomerceAppTheme {
        val isDarkTheme = isSystemInDarkTheme()
        Scaffold(
            topBar = { topBar() }, modifier = Modifier.fillMaxWidth()
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {

                Spacer(Modifier.height(18.dp))

                Row(
                    modifier = Modifier
                        .padding(start = 32.dp, end = 32.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "#SpecialForYou",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isDarkTheme) Color.White else Color.Black,
                        modifier = Modifier.weight(1f)
                    )

                    Box {
                        Text(
                            "See All",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MyCustomColor,
                            modifier = Modifier.align(
                                Alignment.CenterEnd
                            )
                        )

                    }
                }

                Spacer(Modifier.height(8.dp))

                val imageList = listOf(
                    R.drawable.images,
                    R.drawable.images1,
                    R.drawable.images2,
                    R.drawable.images3,
                    R.drawable.download4,
                    R.drawable.download1,
                    R.drawable.download2,
                    R.drawable.download3,
                    R.drawable.download,
                )

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(imageList.size) { index ->
                        val imageRes = painterResource(id = imageList[index])

                        Image(
                            painter = imageRes,
                            contentDescription = "specila offer images",
                            contentScale = (ContentScale.Crop),
                            modifier = Modifier
                                .clip(RoundedCornerShape(32.dp))
                                .width(300.dp)
                                .height(150.dp)
                        )
                    }

                }
                Spacer(modifier = Modifier.height(16.dp))

                Text("Category", fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 32.dp))
            }

        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topBar() {

    var searchItem by rememberSaveable { mutableStateOf("") }
    Column(
        modifier = Modifier.background(color = MyCustomColor),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(Modifier.padding(start = 32.dp)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        tint = Color.White,
                        contentDescription = "Location"
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(
                        "Durban, South Africa",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 32.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    tint = Color.White,
                    contentDescription = " notification icon"
                )

            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, bottom = 32.dp)
                .height(55.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = searchItem,
                onValueChange = { searchItem = it },
                label = { Text("Search") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        tint = MyCustomColor,
                        contentDescription = "search icon",
                        modifier = Modifier.size(28.dp)
                    )
                },
                singleLine = true,
                maxLines = 1,
                shape = RoundedCornerShape(12.dp),
                textStyle = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedTextColor = Color.Black,
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.LightGray,
                    cursorColor = MyCustomColor,
                    containerColor = Color.White,
                    errorBorderColor = Color.Red,
                    disabledLeadingIconColor = Color.LightGray,
                    focusedSupportingTextColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .width(55.dp)
                    .fillMaxHeight()
                    .padding(top = 4.dp),
                colors = CardDefaults.cardColors(
                    Color.White
                )
            ) {
                Box(
                    contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        tint = MyCustomColor,
                        modifier = Modifier.size(28.dp),
                        contentDescription = "search icon"
                    )
                }

            }

        }


    }

}
