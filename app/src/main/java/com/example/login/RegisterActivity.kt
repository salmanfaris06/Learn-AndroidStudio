package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var db: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DBHelper(this@RegisterActivity)

        binding.apply {
            btnRegister.setOnClickListener {
                val uname = inUserReg.text.toString()
                val pass = inPassReg.text.toString()
                val cpass = inCPass.text.toString()
                val saveddata = db.insertData(uname, pass)

                if (TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(cpass)) {
                    Toast.makeText(this@RegisterActivity, "Tambahkan Username, Password dan Konfirmasi Password", Toast.LENGTH_SHORT).show()
                }
                else{
                    if (pass.equals(cpass)){
                        if (saveddata==true){
                            Toast.makeText(this@RegisterActivity, "Register Success", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this@RegisterActivity, "Username Exist", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else{
                        Toast.makeText(this@RegisterActivity, "Passoword Not Match", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            toLogin.setOnClickListener {
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}