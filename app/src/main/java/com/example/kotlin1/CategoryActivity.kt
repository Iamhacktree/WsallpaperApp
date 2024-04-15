package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.example.kotlin1.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
   private val binding: ActivityCategoryBinding by lazy {
    ActivityCategoryBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)


    //to go to bike screen
    val bikeScreen=findViewById<ImageButton>(R.id.imageView)
    bikeScreen.setOnClickListener {
        startActivity(Intent(this,BikeActivity::class.java))
        Toast.makeText(this, "Welcome to Bike Screen",Toast.LENGTH_SHORT).show()
    }
        val spaceScreen=findViewById<ImageButton>(R.id.imageView2)
        spaceScreen.setOnClickListener {
            startActivity(Intent(this,CarsActivity::class.java))
            Toast.makeText(this, "Welcome to Space Screen",Toast.LENGTH_SHORT).show()
        }
        val carScreen=findViewById<ImageButton>(R.id.imageView3)
        carScreen.setOnClickListener {
            startActivity(Intent(this,SpaceActivity::class.java))
            Toast.makeText(this, "Welcome to Cars Screen",Toast.LENGTH_SHORT).show()
        }
        val randomScreen=findViewById<ImageButton>(R.id.imageView4)
        randomScreen.setOnClickListener {
            startActivity(Intent(this,Wallpaper::class.java))
            Toast.makeText(this, "Welcome to Random Screen",Toast.LENGTH_SHORT).show()
        }

    }



}