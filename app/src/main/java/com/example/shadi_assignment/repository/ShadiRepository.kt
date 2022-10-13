package com.example.shadi_assignment.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shadi_assignment.api.ShadiService
import com.example.shadi_assignment.db.ShadiDatabase
import com.example.shadi_assignment.models.Info
import com.example.shadi_assignment.models.modelsNew
import com.example.shadi_assignment.utils.NetworkUtils

class ShadiRepository(
    private val shadiService: ShadiService,
    private val shadiDatabase: ShadiDatabase,
    private val applicationContext: Context
) {

    private val shadiLiveData = MutableLiveData<modelsNew>()

    val data: LiveData<modelsNew>
        get() = shadiLiveData

    suspend fun getData(page: Int){
try {
    if(NetworkUtils.isInternetAvailable(applicationContext)){
        val result = shadiService.getResult(page)
        if(result?.body() != null){
            shadiDatabase.shadiDao().addResult(result.body()!!.results)
            shadiLiveData.postValue(result.body())
        }
    }
    else{
        val data = shadiDatabase.shadiDao().getResult()
        val dataList = modelsNew(Info(1,10,"e565ff756cdabf47","1.4"),data)
        shadiLiveData.postValue(dataList)
    }
} catch (e:Exception)
{
    Log.d("Exception","LoggedException"+e)
}


    }
}