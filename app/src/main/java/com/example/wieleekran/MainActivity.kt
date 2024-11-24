package com.example.wieleekran


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.Text as Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nawigacja()





        }
    }
}
@Composable
fun Nawigacja(){
    val kontroler = rememberNavController()
    NavHost(navController = kontroler, startDestination = ekran.ekran1.droga){
        composable ( route = ekran.ekran1.droga){
            ekran1(navController = kontroler)
        }
        composable (route = ekran.ekran2.droga + "/{imie}"){
            val imie = it.arguments?.getString("imie")?:""
            ekran2(navController = kontroler, imie = imie)
        }
        composable (route = ekran.ekran3.droga+"/{imie}/{nazwisko}"){
            val nazwisko = it.arguments?.getString("nazwisko")?:""
            val imie = it.arguments?.getString("imie")?:""
            ekran3(navController = kontroler, nazwisko = nazwisko, imie = imie)
        }
        composable (route = ekran.ekran4.droga+"/{imie}/{nazwisko}/{potrawa}"){
            val potrawa = it.arguments?.getString("potrawa")?:""
            val nazwisko = it.arguments?.getString("nazwisko")?:""
            val imie = it.arguments?.getString("imie")?:""
            ekran4(navController = kontroler, nazwisko = nazwisko, imie = imie, potrawa = potrawa)
        }
    }
}
@Composable
fun ekran1(navController: NavController){
    var Imie by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(top = 25.dp)
            .background(color = Color.LightGray))
    {


        TextField(

            value = Imie,
            label = {
                Text(
                    text = "Poddaj imię")
            },
            onValueChange = {
                Imie = it
            },
            singleLine = true,

            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ekran.ekran2.droga +"/$Imie")

        }) {
            Text("Wyślij")
        }
    }

}
@Composable
fun ekran2(navController: NavController, imie : String){
    var Nazwisko by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(top = 25.dp)
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "Masz na imię: $imie", style = TextStyle(color = Color.Magenta, fontSize = 20.sp))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(

            value = Nazwisko,
            label = {
                Text(
                    text = "Podaj Nazwisko")
            },
            onValueChange = {
                Nazwisko = it
            },
            singleLine = true,

            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ekran.ekran3.droga+"/$imie /$Nazwisko")

        }) {
            Text("Wyślij")
        }
    }
}
@Composable
fun ekran3(navController: NavController, nazwisko : String, imie : String){

    var ulubiona_potrawa by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(top = 25.dp)
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = "nazywasz się: $imie $nazwisko", style = TextStyle(color = Color.Magenta, fontSize = 20.sp))
        Spacer(modifier = Modifier.height(20.dp))
        TextField(

            value = ulubiona_potrawa,
            label = {
                Text(
                    text = "Podaj Nazwę swojej ulubionej potrawy")
            },
            onValueChange = {
                ulubiona_potrawa = it
            },
            singleLine = true,

            modifier = Modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(fontSize = 20.sp)

        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ekran.ekran4.droga+"/$imie /$nazwisko /$ulubiona_potrawa")

        }) {
            Text("Wyślij")
        }
    }
}
@Composable
fun ekran4(navController: NavController, nazwisko : String, imie : String, potrawa : String){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.DarkGray)
            .padding(top = 25.dp)
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Text(text = "Nazywasz się: $imie $nazwisko,", style = TextStyle(color = Color.Magenta, fontSize = 20.sp))
        Text(text ="twoją ulubioną potrawą jest: $potrawa", style = TextStyle(color = Color.Magenta, fontSize = 20.sp))

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate(ekran.ekran1.droga)

        }) {
            Text("Wróć")
        }
    }
}