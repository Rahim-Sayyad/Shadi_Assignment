package com.example.shadi_assignment.models

import androidx.room.Entity

@Entity
data class Dob(
    val age: Int,
    val date: String
)