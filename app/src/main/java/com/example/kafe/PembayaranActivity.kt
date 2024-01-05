package com.example.kafe

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.kafe.databinding.ActivityMainBinding
import com.example.kafe.databinding.ActivityPembayaranBinding
import com.example.kafe.databinding.CustomDialogBinding

class PembayaranActivity : AppCompatActivity() {

    lateinit var binding: ActivityPembayaranBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPembayaranBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaProduct =intent.getStringExtra(DATA_NAMA)
        val harga =intent.getStringExtra(DATA_HARGA)

        binding.inProduct.text = namaProduct
        binding.inPrice.text = harga

        binding.btnKonfir.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val binding = CustomDialogBinding.inflate(layoutInflater)
            builder.setView(binding.root)

            binding.btnConfirm.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            val alertDialog = builder.create()
            alertDialog.show()
        }
    }

    companion object {
        const val DATA_NAMA = "data_nama"
        const val DATA_HARGA = "data_harga"
    }
}