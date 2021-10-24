package com.example.knowyournetwork.Database

import android.media.Image

data class Topic_DC(
    val Thumbnail : Int,
    val Title : String,
    val subtopic : ArrayList<Subtopic_DC>
)
