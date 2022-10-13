package com.example.shadi_assignment.models

import androidx.room.Entity

@Entity
data class Name(
    val first: String,
    val last: String,
    val title: String
)