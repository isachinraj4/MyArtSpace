package com.example.myartspace.model

import com.example.myartspace.R

data class ArtSpace(val imageResourceId: Int, val aboutImage: String)
val arts = listOf(
    ArtSpace(R.drawable.drawing,"Abstract drawing"),
    ArtSpace(R.drawable.drwimag, "Human face drawing"),
    ArtSpace(R.drawable.face, "Girl face drawing"),
    ArtSpace(R.drawable.fish,"Fish drawing")
)