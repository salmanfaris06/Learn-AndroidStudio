package com.example.login

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, "UserData", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE UserData (username TEXT primary key, password TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS UserData")
    }

    fun insertData(username: String, password: String): Boolean{
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username", username)
        cv.put("password", password)
        val result = db.insert("UserData", null, cv)
        if (result==-1 .toLong()){
            return false
        }
        return true
    }

    fun checkuserpass(username: String, password: String): Boolean {
        val db = this.writableDatabase
        val query = "SELECT * FROM UserData WHERE username= '$username' AND password = '$password'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count<=0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }


}