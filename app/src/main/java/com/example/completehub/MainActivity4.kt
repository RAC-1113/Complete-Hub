package com.example.completehub

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        val firstname = findViewById<TextView>(R.id.first_name)
        val lastname = findViewById<TextView>(R.id.last_name)
        val username = findViewById<TextView>(R.id.user_name)
        val branch = findViewById<TextView>(R.id.branch)

        firstname.text= intent.getStringExtra("First Name")!!
        lastname.text = intent.getStringExtra("Last Name")!!
        username.text = intent.getStringExtra("User name")!!
        branch.text = intent.getStringExtra("Stream")!!

        val profileBtn=findViewById<ImageView>(R.id.profilebtn)
        profileBtn.setOnClickListener {
            val profile_Btn = Intent(this, MainActivity3::class.java).apply {
                putExtra("First Name", firstname.text.toString())
                putExtra("Last Name", lastname.text.toString())
                putExtra("User name", username.text.toString())
                putExtra("Stream", branch.text.toString())
            }
            startActivity(profile_Btn)
        }

        val eventBtn=findViewById<ImageView>(R.id.eventupload)
        eventBtn.setOnClickListener {
            val goevent= Intent(this, MainActivity5::class.java)
            startActivity(goevent)
        }

        val eventdispBtn = findViewById<ImageView>(R.id.eventdisp)
        eventdispBtn.setOnClickListener {
            val dispevent = Intent(this, RecyclerView::class.java)
            startActivity(dispevent)
        }

        val searcheventBtn = findViewById<ImageView>(R.id.searchevent)
        searcheventBtn.setOnClickListener {
            val showevent = Intent(this, ReadData::class.java)
            startActivity(showevent)
        }

       /*val profile_Btn = findViewById<ImageView>(R.id.profilebtn)
       profile_Btn.setOnClickListener {
           val goprof = Intent(this, MainActivity3::class.java)
           startActivity(goprof)
       }*/

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}