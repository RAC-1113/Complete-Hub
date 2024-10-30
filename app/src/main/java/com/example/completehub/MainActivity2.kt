package com.example.completehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val inputfirstname = findViewById<EditText>(R.id.input_firstname_)
        val inputlastname = findViewById<EditText>(R.id.input_lastname_)
        val inputbranch = findViewById<EditText>(R.id.input_branch)
        val inputusername = findViewById<EditText>(R.id.input_username_)
        //val inputpassword = findViewById<EditText>(R.id.input_password)

        val RegisterButton = findViewById<Button>(R.id.btnRegister)

        RegisterButton.setOnClickListener {

            if(inputfirstname.text.toString().isEmpty()){
                inputfirstname.error="Can't be empty"
            }
            else if(inputlastname.text.toString().isEmpty()){
                inputlastname.error="Can't be empty"
            }
            else if(inputbranch.text.toString().isEmpty()){
                inputbranch.error="Can't be empty"
            }
            else if(inputusername.text.toString().isEmpty()){
                inputusername.error="Can't be empty"
            }
            /*else if(inputpassword.text.toString().isEmpty()){
                inputpassword.error="Can't be empty"
            }*/
            else{
                val RegisterButtonIntent= Intent(this, MainActivity4::class.java).apply {
                    Toast.makeText(applicationContext, "Registration Successful", Toast.LENGTH_SHORT).show()
                    putExtra("First Name",inputfirstname.text.toString())
                    putExtra("Last Name", inputlastname.text.toString())
                    putExtra("Stream", inputbranch.text.toString())
                    putExtra("User name", inputusername.text.toString())

                }
                startActivity(RegisterButtonIntent)
                /*val RegisterButtonIntent = findViewById<Button>(R.id.btnRegister)
                RegisterButtonIntent.setOnClickListener {
                    Toast.makeText(applicationContext, "Registration Successful", Toast.LENGTH_SHORT).show()
                    val golog = Intent(this, MainActivity::class.java)
                    startActivity(golog)
                }*/
            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}