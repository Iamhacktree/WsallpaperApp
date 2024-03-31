package com.example.kotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Wallpaper : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList: ArrayList<Int>
    lateinit var titlList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpaper)

        imageList = arrayListOf(
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,
            R.drawable.image,

        )
        titlList = arrayListOf(
            "chirag",
            "chirag",
            "chirag",
            "chirag",
            "chirag",

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
        recyclerView.adapter= AdapterClass(dataList)
    }

}