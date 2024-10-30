package com.example.completehub

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RecyclerView : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var eventRecyclerview : RecyclerView
    private lateinit var eventArrayList : ArrayList<EventDisplay>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)

        eventRecyclerview = findViewById(R.id.EventList)
        eventRecyclerview.layoutManager = LinearLayoutManager(this)
        eventRecyclerview.setHasFixedSize(true)

        eventArrayList = arrayListOf<EventDisplay>()
        getEventData()


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getEventData() {

        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    for(eventSnapshot in snapshot.children){

                        val event = eventSnapshot.getValue(EventDisplay::class.java)
                        eventArrayList.add(event!!)

                    }

                    eventRecyclerview.adapter = MyAdapter(eventArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })

    }
}