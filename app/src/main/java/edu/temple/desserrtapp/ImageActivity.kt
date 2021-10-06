package edu.temple.desserrtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)
            imageView.setImageResource(items[itemPosition].resourceId)
            textView.text = items[itemPosition].description
        }

        recyclerView.adapter = ImageAdapter(items, onClickListener)
    }

    // Test data
    fun generateTestData(): Array<Item> {
        return arrayOf(Item(R.drawable.ccf_original, "Original")
            , Item(R.drawable.ccf_freshstrawberry,"Fresh Strawberry")
            , Item(R.drawable.ccf_chocolatecaramelicious,"Chocolate Caramelicious Cheesecake ")
            , Item(R.drawable.ccf_pineappleupsidedown,"Pineapple Upside-Down")
            , Item(R.drawable.ccf_celebration,"Celebration")
            , Item(R.drawable.ccf_caramelapple,"Caramel Apple")
            , Item(R.drawable.ccf_verycherryghirardellichocolate,"Very Cherry Ghirardelli® Chocolate")
            , Item(R.drawable.ccf_lowlicious,"Low-Licious")
            , Item(R.drawable.ccf_cinnaboncinnamoncwirl,"Cinnabon® Cinnamon Swirl")
            , Item(R.drawable.ccf_godiva,"Godiva® Chocolate")
            , Item(R.drawable.ccf_coconutcreampie,"Coconut Cream Pie")
            , Item(R.drawable.ccf_saltedcaramel,"Salted Caramel"))
    }
}