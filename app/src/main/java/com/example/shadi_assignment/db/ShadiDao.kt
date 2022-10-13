package com.example.shadi_assignment.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.shadi_assignment.models.Result

@Dao
interface ShadiDao {

    @Insert
    fun addResult(quotes: List<Result>)

    @Query("SELECT * FROM result")
    fun getResult() : List<Result>



}