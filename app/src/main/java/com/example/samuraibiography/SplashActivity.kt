package com.example.samuraibiography

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import java.time.OffsetDateTime
import android.content.Intent
import android.annotation.SuppressLint

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000 // 3 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Handler untuk menangani perpindahan ke activity utama setelah splash screen
        Handler().postDelayed({
            //intent untuk memindahkan activity utama
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)

            //menutup activity splash agar tidak dikembalikan
            finish()

        }, SPLASH_DELAY)

        val logoImageView1: ImageView = findViewById(R.id.logoImage1)
        val logoImageView2: ImageView = findViewById(R.id.logoImage2)
        val samurai: ImageView = findViewById(R.id.samuraiImageView)
        //animasi fade-in untuk logo-1
        logoImageView1.apply {
            alpha =  0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(1500).setListener(null)
        }

        logoImageView2.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(1600).setStartDelay(500).setListener(null)
        }

        samurai.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate().alpha(1f).setDuration(1600).setStartDelay(1000).setListener(null)
        }


    }
}