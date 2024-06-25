package com.example.importimagesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editTextField)
        button = findViewById(R.id.button)
        imageView = findViewById(R.id.imageViewField)

        button.setOnClickListener{
            val url = editText.text.toString().trim()
            if (url.isNotEmpty()) {
                downloadAndDisplayImage(url)
            } else {
                Toast.makeText(this, "ОШИБОЧКА ВЫШЛА", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun downloadAndDisplayImage(url: String) {
        val requestOptions = RequestOptions()
            .placeholder(R.drawable.dowwnloadin) // PLACEHOLDER
            .error(R.drawable.scale_1200) // MISTAKES WERE MADE
            .diskCacheStrategy(DiskCacheStrategy.ALL)

        // Загружаем и отображаем изображение с помощью Glide
        Glide.with(this)
            .load(url)
            .apply(requestOptions)
            .into(imageView)
    }
}