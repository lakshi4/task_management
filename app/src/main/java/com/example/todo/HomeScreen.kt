package com.example.todo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_splashsceen)
            val thread = object : Thread() {
                override fun run() {
                    try {
                        sleep(5000)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    } finally {
                        val mainIntent = Intent(this@HomeScreen, MainActivity::class.java)
                        startActivity(mainIntent)
                    }
                }
            }
            thread.start()
        }

        override fun onPause() {
            super.onPause()
            finish()
        }
    }
