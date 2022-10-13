package com.example.shadi_assignment.adapter

import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shadi_assignment.R
import com.example.shadi_assignment.models.Result


class RvAdapter(val userList: List<Result>) : RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.adapter_item_layout, p0, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name?.text = userList[p1].name.title + userList[p1].name.first + userList[p1].name.last
        //p0.count?.text = userList[p1].count.toString()
        Glide.with(p0.itemView)
            .load(userList[p1].picture.large)
            .into(p0.profileImage)
        p0.age.text = userList[p1].dob.age.toString()
        p0.city.text = userList[p1].location.city
        p0.state.text = userList[p1].location.state
        p0.country.text = userList[p1].location.country

        val preferences = PreferenceManager.getDefaultSharedPreferences(p0.name.context)
        var btnReject = preferences.getString(userList[p1].email +"Reject", "")
        var btnAccept = preferences.getString(userList[p1].email +"Accept", "")
        if(btnAccept!!.contains("Accept"))
        {
            p0.btnAccept.text = "Member Accepted"
            //p0.btnReject.visibility = View.GONE
        }
        else if(btnReject!!.contains("Reject"))
        {
            p0.btnReject.text = "Member Rejected"
           // p0.btnAccept.visibility = View.GONE
        }
if(p0.btnAccept.visibility == View.VISIBLE) {
    p0.btnAccept.setOnClickListener {
        val preferences = PreferenceManager.getDefaultSharedPreferences(p0.name.context)
        val editor = preferences.edit()
        editor.putString(userList[p1].email + "Accept", "Member Accepted")
        editor.apply()
        p0.btnAccept.text = "Member Accepted"
        p0.btnReject.visibility = View.GONE
    }
}
        if(p0.btnReject.visibility == View.VISIBLE) {
            p0.btnReject.setOnClickListener {
                val preferences = PreferenceManager.getDefaultSharedPreferences(p0.name.context)
                val editor = preferences.edit()
                editor.putString(userList[p1].email + "Reject", "Member Rejected")
                editor.apply()
                p0.btnReject.text = "Member Rejected"
                p0.btnAccept.visibility = View.GONE
            }
        }


    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val age = itemView.findViewById<TextView>(R.id.tvAge)
        val city = itemView.findViewById<TextView>(R.id.tvCity)
        val state = itemView.findViewById<TextView>(R.id.tvState)
        val country = itemView.findViewById<TextView>(R.id.tvCountry)
        val profileImage = itemView.findViewById<ImageView>(R.id.profile_image)
        val btnAccept = itemView.findViewById<Button>(R.id.btnAccept)
        /*.setOnClickListener{
            val preferences = PreferenceManager.getDefaultSharedPreferences(name.context)
            val editor = preferences.edit()
            editor.putString("btnAccept", "Member Accepted")
            editor.apply()
        }*/

        val btnReject = itemView.findViewById<Button>(R.id.btnReject)
    /*.setOnClickListener{
            val preferences = PreferenceManager.getDefaultSharedPreferences(name.context)
            val editor = preferences.edit()
            editor.putString("btnReject", "Member Rejected")
            editor.apply()
        }*/

    }
}
