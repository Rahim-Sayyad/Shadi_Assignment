package com.example.shadi_assignment.models

import androidx.room.TypeConverter
import com.google.gson.Gson

class MyTypeConverters {

    @TypeConverter
    fun dobToString(app: Dob): String = Gson().toJson(app)

    @TypeConverter
    fun stringToDob(string: String): Dob = Gson().fromJson(string, Dob::class.java)

    @TypeConverter
    fun idToString(app: Id): String = Gson().toJson(app)

    @TypeConverter
    fun stringToId(string: String): Id = Gson().fromJson(string, Id::class.java)

    @TypeConverter
    fun locationToString(app: Location): String = Gson().toJson(app)

    @TypeConverter
    fun stringToLocation(string: String): Location = Gson().fromJson(string, Location::class.java)

    @TypeConverter
    fun nameToString(app: Name): String = Gson().toJson(app)

    @TypeConverter
    fun stringToName(string: String): Name = Gson().fromJson(string, Name::class.java)

    @TypeConverter
    fun pictureToString(app: Picture): String = Gson().toJson(app)

    @TypeConverter
    fun stringToPicture(string: String): Picture = Gson().fromJson(string, Picture::class.java)

    @TypeConverter
    fun registeredToString(app: Registered): String = Gson().toJson(app)

    @TypeConverter
    fun stringToRegistered(string: String): Registered = Gson().fromJson(string, Registered::class.java)

    @TypeConverter
    fun loginToString(app: Login): String = Gson().toJson(app)

    @TypeConverter
    fun stringToLogin(string: String): Login = Gson().fromJson(string, Login::class.java)

}