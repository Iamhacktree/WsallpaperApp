package com.example.kotlin1

import AdapterClass
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin1.DataClass
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
//import com.example.kotlin1.databinding.ActivityWallpaperBinding
import android.content.res.Configuration
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView

class SpaceActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: ArrayList<Int>
    lateinit var titlList: ArrayList<String>


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_space)

        imageList = arrayListOf(
            R.drawable.image,
            R.drawable.img,
            R.drawable.bike1,
            R.drawable.bike2,
            R.drawable.mountain1,
            R.drawable.space1,
            R.drawable.scene1,
            R.drawable.cars2,

            )
        titlList = arrayListOf(
            "K. Rock",
            "M. Rat",
            "T Raja",
            "Tiger",
            "kishor",
            "kunal",
            "harsh",
            "Tiger",


            )
        recyclerView = findViewById(R.id.recycleViewMain)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        getData()

    }

    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i], titlList[i])
            dataList.add(dataClass)
        }
        val adapter = AdapterClass(this, dataList) // Pass context and dataList to AdapterClass constructor
        recyclerView.adapter = adapter

///      recyclerView.adapter= AdapterClass(dataList)

    }
}