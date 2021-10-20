package edu.temple.desserrtapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = getString(R.string.selectorTitle)

        val items = generateTestData()

        supportFragmentManager.beginTransaction()
            .add(R.id.selectionContainer, SelectionFragment.newInstance(items))

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
        val desserts = resources.getStringArray(R.array.dessert_names)
        return arrayOf(Item(R.drawable.ccf_original, desserts[0].toString())
            , Item(R.drawable.ccf_freshstrawberry,desserts[1].toString())
            , Item(R.drawable.ccf_chocolatecaramelicious,desserts[2].toString())
            , Item(R.drawable.ccf_pineappleupsidedown,desserts[3].toString())
            , Item(R.drawable.ccf_celebration,desserts[4].toString())
            , Item(R.drawable.ccf_caramelapple,desserts[5].toString())
            , Item(R.drawable.ccf_verycherryghirardellichocolate,desserts[6].toString())
            , Item(R.drawable.ccf_lowlicious,desserts[7].toString())
            , Item(R.drawable.ccf_cinnaboncinnamoncwirl,desserts[8].toString())
            , Item(R.drawable.ccf_godiva,desserts[9].toString())
            , Item(R.drawable.ccf_coconutcreampie,desserts[10].toString())
            , Item(R.drawable.ccf_saltedcaramel,desserts[11].toString()))
    }
}