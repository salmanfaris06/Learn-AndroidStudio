package com.example.kafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kafe.PembayaranActivity.Companion.DATA_HARGA
import com.example.kafe.PembayaranActivity.Companion.DATA_NAMA
import com.example.kafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnDamai.setOnClickListener {
                getData("Kopi Damai", "Rp. 10.000")
            }
            btnItam.setOnClickListener {
                getData("Kopi Itam", "Rp. 9.000")
            }
            btnJoss.setOnClickListener {
                getData("Kopi Joss", "Rp. 20.000")
            }
            btnSehat.setOnClickListener {
                getData("Kopi Sehat", "Rp. 50.000")
            }
        }
    }

    private fun getData(namaProduct: String, harga: String) {
        val intent = Intent(this, PembayaranActivity::class.java)
        intent.putExtra(DATA_NAMA, namaProduct)
        intent.putExtra(DATA_HARGA, harga)
        startActivity(intent)
    }
}