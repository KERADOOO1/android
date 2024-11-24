package com.example.wieleekran

sealed class ekran (val droga: String){
    object  ekran1 : ekran("ekran1")
    object  ekran2 : ekran("ekran2")
    object  ekran3 : ekran("ekran3")
    object  ekran4 : ekran("ekran4")
}