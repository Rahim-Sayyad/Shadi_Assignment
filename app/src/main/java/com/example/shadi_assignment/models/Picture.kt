package com.example.shadi_assignment.models

import androidx.room.Entity

@Entity
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)