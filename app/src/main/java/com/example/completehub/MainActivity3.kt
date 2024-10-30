package com.example.completehub

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val first_name= findViewById<TextView>(R.id.display_firstname)
        val last_name= findViewById<TextView>(R.id.display_lastname)
        val user_name= findViewById<TextView>(R.id.display_username)
        val branch= findViewById<TextView>(R.id.display_branch)

        first_name.text = intent.getStringExtra("First Name")!!
        last_name.text = intent.getStringExtra("Last Name")!!
        user_name.text = intent.getStringExtra("User name")!!
        branch.text = intent.getStringExtra("Stream")!!

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}