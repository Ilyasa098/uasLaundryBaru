package com.example.uaslaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        firebaseAuth = FirebaseAuth.getInstance()

        tvEmail.text = firebaseAuth.currentUser!!.email

        btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            val toLogin = Intent(this,LoginActivity::class.java)
            startActivity(toLogin)
        }
    }
}