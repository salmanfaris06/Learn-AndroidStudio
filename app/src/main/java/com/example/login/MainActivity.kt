package com.example.login


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dbh: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            btnLogin.setOnClickListener {
                val user = inUser.text.toString()
                val passwd = inPass.text.toString()
                dbh = DBHelper(this@MainActivity)

                if (TextUtils.isEmpty(user) || TextUtils.isEmpty(passwd)){
                    Toast.makeText(this@MainActivity, "Tambahkan Usename dan Password", Toast.LENGTH_SHORT).show()
                }
                else{
                    val checkuser = dbh.checkuserpass(user, passwd)
                    if (checkuser == true || user=="admin" && passwd=="admin"){
                        if (user=="admin" && passwd=="admin"){
                            Toast.makeText(this@MainActivity, "Login Admin Succesfull", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@MainActivity, AdminActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(this@MainActivity, "Login User Succesfull", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this@MainActivity, UserActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    else{
                        Toast.makeText(this@MainActivity, "Wrong Username and Password", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            toRegister.setOnClickListener{
                val intent = Intent(this@MainActivity, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}