package com.dvach.lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    lateinit var sPref: SharedPreferences
    var savedToken: String? = null
    var kaef: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadText()
        if (kaef == true) {
            if (savedToken != null) {
                val i = Intent(this, MainActivity::class.java)
                startActivity(i)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        finish()
    }

    fun loadText() {
        sPref = getSharedPreferences("kek", Context.MODE_PRIVATE)
        if (sPref.contains("token") ) {
            savedToken = sPref.getString("token", "")
            kaef = true
            //   Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
        }

    }
}
