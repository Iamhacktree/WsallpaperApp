package com.example.kotlin1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow

class PhoToCategoryScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pho_to_category_screen)



        val gotoSpace = findViewById<TableRow>(R.id.spaces)
        val gotoBikes = findViewById<TableRow>(R.id.bikes)
        val gotoMountain = findViewById<TableRow>(R.id.mountain)
        val gotoForest = findViewById<TableRow>(R.id.forest)
        val gotocars = findViewById<TableRow>(R.id.cars)


        gotoSpace.setOnClickListener{
            val intent = Intent(applicationContext, SpacePage::class.java)
            startActivity(intent)
        }
        gotoBikes.setOnClickListener{
            val intent = Intent(applicationContext, BikesPage::class.java)
            startActivity(intent)
        }
        gotoMountain.setOnClickListener{
            val intent = Intent(applicationContext, MountainPage::class.java)
            startActivity(intent)
        }
        gotoForest.setOnClickListener{
            val intent = Intent(applicationContext, ForestPage::class.java)
            startActivity(intent)
        }
        gotocars.setOnClickListener{
            val intent = Intent(applicationContext, CarsPage::class.java)
            startActivity(intent)
        }
    }
}