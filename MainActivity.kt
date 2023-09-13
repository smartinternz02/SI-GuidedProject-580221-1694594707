package com.example.day4task

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.ImeAction
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
//import androidx.compose.material3.ExperimentalMaterialApi


import com.example.day4task.ui.theme.Day4taskTheme
import androidx.compose.foundation.layout.Column as Column1
import androidx.compose.material3.Card as Card1

data class Movie(val title: String,val poster:Int)

val movies = listOf(
    Movie("movie 1",R.drawable.i),
    Movie("movie 2",R.drawable.b),
    Movie("movie 3",R.drawable.c),
    Movie("movie 4",R.drawable.d),
    Movie("movie 5",R.drawable.e),
    Movie("movie 6",R.drawable.f),
    Movie("movie 7",R.drawable.g),
    Movie("movie 8",R.drawable.h),
    Movie("movie 9",R.drawable.a),
)
@Composable
fun MovieList(){
    LazyColumn{
        items(movies){ movie ->
            MovieItem(movie = movie)
        }
    }
}
//@OptIn(ExperimentalMaterialApi::class)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieItem(movie: Movie){
    Card1(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick ={
            //Note ye hai ki :here we will use to navigate to other page or web page
        }
    ) {
        Column1 (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
           Image(
               painter = painterResource(id = movie.poster),
               contentDescription = movie.title,
               modifier = Modifier
                   .fillMaxWidth()
                   .height(200.dp),
               contentScale = ContentScale.Crop
           )
            Spacer(modifier = Modifier.height(16.dp))
            Text(movie.title, fontWeight = FontWeight.Bold)
        }

    }
}

@Composable
fun Searchbar(onQueryChange: (String)->Unit){
    var query by remember { mutableStateOf("") }

    BasicTextField(
        value = query,
        onValueChange = {
            query = it
            onQueryChange(it)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                //handel search action
            }
        ),
        modifier = Modifier.run{
            fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.primary)
        }
    )
}

@Composable
fun MovieRecommendationApp(){
    var filteredMovies by remember { mutableStateOf(movies) }

    Column1 (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Searchbar{
            query ->
            filteredMovies = if(query.isEmpty()){
                movies
            } else{
                movies.filter{ it.title.contains(query , ignoreCase = true)}
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        MovieList()

    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day4taskTheme {
                MovieRecommendationApp()

            }
        }
    }
}