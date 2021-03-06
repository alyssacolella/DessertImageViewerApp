package edu.temple.desserrtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Dessert Selection"

        val items = generateTestData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)

        // View.OnClickListener is created in the activity
        // and then passed to adapter
        // This allows the onClick() callback
        // to have access to the activity's members
        val onClickListener = View.OnClickListener {
            val itemPosition = recyclerView.getChildAdapterPosition(it)

            val intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("dessertName", items[itemPosition].description)
            intent.putExtra("dessertImage", items[itemPosition].resourceId)

            startActivity(intent)
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
            , Item(R.drawable.ccf_verycherryghirardellichocolate,"Very Cherry Ghirardelli┬« Chocolate")
            , Item(R.drawable.ccf_lowlicious,"Low-Licious")
            , Item(R.drawable.ccf_cinnaboncinnamoncwirl,"Cinnabon┬« Cinnamon Swirl")
            , Item(R.drawable.ccf_godiva,"Godiva┬« Chocolate")
            , Item(R.drawable.ccf_coconutcreampie,"Coconut Cream Pie")
            , Item(R.drawable.ccf_saltedcaramel,"Salted Caramel"))
    }
}