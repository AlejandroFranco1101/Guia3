
package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnAbrir: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAbrir = findViewById(R.id.btnAbrir)
        lifecycle.addObserver(MyLifeCycleObserver("MainActivity"))
        btnAbrir.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        mostrarToast("onCreate")
    }

    override fun onStart() {
        super.onStart()
        mostrarToast("onStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarToast("onResume")
    }

    override fun onPause() {
        super.onPause()
        mostrarToast("onPause")
    }

    override fun onStop() {
        super.onStop()
        mostrarToast("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarToast("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarToast("onDestroy")
    }

    private fun mostrarToast(
        mensaje: String,
        duracion: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(
            this,
            "MainActivity -> $mensaje",
            duracion
        ).show()
    }
}
