package com.e.usertp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.e.usertp.databinding.ActivityFullUserBinding

class FullUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityFullUserBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_full_user)
        val user = intent.getSerializableExtra("user") as User
        binding.user = user

        /*val nom = findViewById<TextView>(R.id.nom)
        val prenom = findViewById<TextView>(R.id.prenom)
        val age = findViewById<TextView>(R.id.age)

        nom.text = user.nom
        prenom.text = user.prenom
        age.text = user.age.toString()*/
    }

}
