package com.example.uaslaundry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailsLaundry : AppCompatActivity() {
    private lateinit var rvLaundry: RecyclerView
    private lateinit var tvHargaTotal: TextView
    private lateinit var tvCounterTotal: TextView
    private lateinit var btnCheckout: Button
    private lateinit var pembayaranViewModel: PembayaranViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_laundry)
        rvLaundry = findViewById(R.id.rvLaundryDetail)
        btnCheckout = findViewById(R.id.btnCheckout)
        tvCounterTotal = findViewById(R.id.tvCounterTotal)
        tvHargaTotal = findViewById(R.id.tvHargaTotalLaundry)
        pembayaranViewModel = ViewModelProvider(this)[PembayaranViewModel::class.java]

        pembayaranViewModel.resetCounter()

        rvLaundry.layoutManager = LinearLayoutManager(this)
        rvLaundry.adapter = LaundryAdapter(listBaju,this,pembayaranViewModel)

        pembayaranViewModel.hargaTotal.observe(this){newValue ->
            tvHargaTotal.text = newValue.toString()
            tvCounterTotal.text = pembayaranViewModel.counter.value.toString()
        }

        btnCheckout.setOnClickListener {
            val toPembayaran = Intent(this,PaymentActivity::class.java)
            startActivity(toPembayaran)
        }

        }

}
