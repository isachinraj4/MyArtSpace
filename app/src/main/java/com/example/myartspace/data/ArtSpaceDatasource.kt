package com.example.myartspace.data

import com.example.myartspace.R
import com.example.myartspace.model.ArtSpace

class ArtSpaceDatasource {
    fun loadArtSpace(): List<ArtSpace> {
        return listOf(
            ArtSpace(R.drawable.drawing,"Abstract drawing"),
            ArtSpace(R.drawable.drwimag, "Human face drawing"),
            ArtSpace(R.drawable.face, "Girl face drawing"),
            ArtSpace(R.drawable.fish,"Fish drawing")
        )
    }
}