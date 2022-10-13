package com.example.shadi_assignment.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shadi_assignment.models.Result

@Database(entities = [Result::class], version = 1)
abstract class ShadiDatabase : RoomDatabase() {

    abstract fun shadiDao() : ShadiDao

    companion object{
        @Volatile
        private var INSTANCE: ShadiDatabase? = null

        fun getDatabase(context: Context): ShadiDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        ShadiDatabase::class.java,
                        "shadiDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}