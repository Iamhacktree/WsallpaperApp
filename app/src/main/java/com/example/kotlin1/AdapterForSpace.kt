package com.example.kotlin1

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

//class AdapterForSpace {
//}

class AdapterForSpace(private val context: Context, private val dataList: ArrayList<DataClassSpace>) :
    RecyclerView.Adapter<AdapterForSpace.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataList[position]
        holder.imageView.setImageResource(currentItem.dataImage)
        holder.imageView.setOnClickListener {
            // Get the bitmap from the ImageView
            val drawable = holder.imageView.drawable
            val bitmap = (drawable as BitmapDrawable).bitmap

            // Save the bitmap to the device
            saveImageToGallery(context, bitmap)
        }
    }

    private fun saveImageToGallery(context: Context, bitmap: Bitmap) {
        val savedImageUri = MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap,
            "downloadedImage",
            "wallpaper app"
        )

        if (savedImageUri != null) {
            // Image saved successfully
            Toast.makeText(context, "Image saved successfully", Toast.LENGTH_SHORT).show()
        } else {
            // Image save failed
            Toast.makeText(context, "Failed to save image", Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.firstimage)
    }
}
