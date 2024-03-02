package com.example.samuraibiography

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvSamurai : RecyclerView
    private val list = ArrayList<Samurai>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvSamurai = findViewById(R.id.rv_samurai)
        rvSamurai.setHasFixedSize(true)

        supportActionBar?.show()


        list.addAll(getListSamurai())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main , menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showSelectedSamurai(samurai: Samurai) {
        Toast.makeText(this, "You choice" + samurai.name, Toast.LENGTH_SHORT).show()
    }


    @SuppressLint("Recycle")
    private fun getListSamurai(): ArrayList<Samurai> {
        val dataName = resources.getStringArray(R.array.data_name)
        val description = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listSamurai = ArrayList<Samurai>()

        for (i in dataName.indices) {
            val samurai  = Samurai(dataName[i], description[i], dataPhoto.getResourceId(i, -1) )
            listSamurai.add(samurai)

        }
        return listSamurai

    }

    private fun showRecyclerList() {
        rvSamurai.layoutManager = LinearLayoutManager(this)
        val listSamuraiAdapter = ListSamuraiAdapter(list)
        rvSamurai.adapter = listSamuraiAdapter
        listSamuraiAdapter.setOnItemClickCallback(object: ListSamuraiAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Samurai) {
                showSelectedSamurai(data)
            }
        })
    }
}