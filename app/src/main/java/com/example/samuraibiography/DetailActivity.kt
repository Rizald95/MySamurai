package com.example.samuraibiography

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    companion object {
        const val IMG = "SamuraiImg"
        const val DESCRIPTION = "SamuraiDescription"
        const val NAME = "SamuraiName"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val SamuraiImg = intent.getIntExtra(IMG, R.id.img_item_photo)
        val SamuraiName = intent.getStringExtra(NAME)
        val SamuraiDesc = intent.getStringExtra(DESCRIPTION)




        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val nameSamurai: TextView = findViewById(R.id.tv_item_name)
        val descriptionSamurai: TextView = findViewById(R.id.tv_item_description)

        imgPhoto.setImageResource(SamuraiImg)
        nameSamurai.text = SamuraiName
        descriptionSamurai.text = SamuraiDesc

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val SamuraiName = intent.getStringExtra(NAME)
                val SamuraiDesc = intent.getStringExtra(DESCRIPTION)
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "Samurai name : " + SamuraiName + "\n Character Description : " + SamuraiDesc)
                    type = "text/plain"
                }
                val shareMyIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareMyIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}