package com.example.completehub

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.completehub.databinding.ActivityMain5Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity5 : AppCompatActivity() {

    private lateinit var binding : ActivityMain5Binding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        binding= ActivityMain5Binding.inflate(getLayoutInflater())
        setContentView(binding.root)

        binding.UploadBtn.setOnClickListener {
            
            val EventName = binding.EventName.text.toString()
            val EventDate = binding.EventDate.text.toString()
            val EventLocation = binding.EventLocation.text.toString()
            val EventMode = binding.EventMode.text.toString()
            val EventCoordinator = binding.EventCoordinator.text.toString()
            val EventContact = binding.EventContact.text.toString()
            val EventDescription = binding.EventDescription.text.toString()


            database = FirebaseDatabase.getInstance().getReference("Users")
            val User = User(EventName, EventDate, EventLocation, EventMode, EventCoordinator, EventContact,
                EventDescription)
            database.child(EventName).setValue(User).addOnSuccessListener {

                binding.EventName.text.clear()
                binding.EventDate.text.clear()
                binding.EventLocation.text.clear()
                binding.EventMode.text.clear()
                binding.EventCoordinator.text.clear()
                binding.EventContact.text.clear()
                binding.EventDescription.text.clear()

                Toast.makeText(this, "Successfully uploaded", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {

                Toast.makeText(this, "Upload Failed", Toast.LENGTH_SHORT).show()

            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}