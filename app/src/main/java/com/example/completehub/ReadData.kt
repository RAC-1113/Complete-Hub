package com.example.completehub

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.completehub.databinding.ActivityReadDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ReadData : AppCompatActivity() {

    private lateinit var binding : ActivityReadDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadDataBinding.inflate(getLayoutInflater())
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.searcheventBtn.setOnClickListener {

            val eventName : String = binding.inputeventname.text.toString()

            if(eventName.isNotEmpty()){

                readData(eventName)

            }else{

                Toast.makeText(this,"Please Enter an Event Name",Toast.LENGTH_SHORT).show()

            }

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun readData(eventName: String) {

        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(eventName).get().addOnSuccessListener {

            if(it.exists()){

                val eventname = it.child("eventname").value
                val eventdate = it.child("eventdate").value
                val eventdescription = it.child("eventdescription").value
                val eventmode = it.child("eventmode").value
                val eventlocation = it.child("eventlocation").value
                val eventcoordinator = it.child("eventcoordinator").value
                val eventcontact = it.child("eventcontact").value
                Toast.makeText(this,"Event Found",Toast.LENGTH_SHORT).show()
                binding.inputeventname.text.clear()

                binding.Eventnamee.text = eventname.toString()
                binding.Eventdatee.text = eventdate.toString()
                binding.Eventdescriptionn.text = eventdescription.toString()
                binding.Eventmodee.text = eventmode.toString()
                binding.Eventlocationn.text = eventlocation.toString()
                binding.Eventcoordinatorss.text = eventcoordinator.toString()
                binding.Eventcontactt.text = eventcontact.toString()




            }else{

                Toast.makeText(this,"Such Event does not exist",Toast.LENGTH_SHORT).show()

            }

        }.addOnFailureListener {

            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

        }

    }
}




