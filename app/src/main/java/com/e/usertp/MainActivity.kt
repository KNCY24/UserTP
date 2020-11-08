package com.e.usertp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userlist = mutableListOf ( User("Mariema","Kency",19),User("Rousseau","Emma",21),
            User("Sadgal","Rania",19),User("Nadir","Samira",43) )

        for (i in 0 until (1000)) userlist.add(User("nom"+i,"prenom"+i,i))

        val recycler = findViewById<RecyclerView>(R.id.recyclerview)
        recycler.layoutManager = LinearLayoutManager(this)
        val intent = Intent(this, FullUserActivity::class.java)
        recycler.adapter = MyAdapter(userlist, {position ->
            //c'est ici que le click est transmis à l'activité
            //Log.v("MyUserList","numéro de l'item cliqué: $position")
            intent.putExtra("user",userlist[position])
            startActivity(intent)
        })

    }
}
