package edu.temple.desserrtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        supportActionBar?.title = "Dessert Display"

        val dessertText = intent.getStringExtra("dessertName")

        val bundle: Bundle? = intent.extras
        val resId: Int = bundle!!.getInt("dessertImage")

        //val dessertImg = intent.getInt("dessertImage")

        findViewById<TextView>(R.id.textView).text = dessertText
        findViewById<ImageView>(R.id.imageView).setImageResource(resId)
    }
}