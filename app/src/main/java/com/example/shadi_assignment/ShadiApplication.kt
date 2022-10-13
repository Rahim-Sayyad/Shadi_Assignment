package com.example.shadi_assignment

import android.app.Application
import com.example.shadi_assignment.api.RetrofitHelper
import com.example.shadi_assignment.api.ShadiService
import com.example.shadi_assignment.db.ShadiDatabase
import com.example.shadi_assignment.repository.ShadiRepository

class ShadiApplication : Application() {

    lateinit var shadiRepository: ShadiRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val shadiService = RetrofitHelper.getInstance().create(ShadiService::class.java)
        val database = ShadiDatabase.getDatabase(applicationContext)
        shadiRepository = ShadiRepository(shadiService, database, applicationContext)
    }
}