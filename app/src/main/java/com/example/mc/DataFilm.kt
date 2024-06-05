package com.example.mc

import com.google.firebase.database.Exclude

data class DataFilm(
    val Actor : String? =null,
    val Drirector : String? =null,
    val Gendre : String? =null,
    val Synopsice : String? =null,
    val imgUrl : String? =null,
    val judul : String? =null,

    @get:Exclude
    @set:Exclude
    var key:String?=null

)
