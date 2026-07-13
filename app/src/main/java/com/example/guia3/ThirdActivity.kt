package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    private lateinit var btnMain: Button
    private lateinit var btnSecond: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        btnMain = findViewById(R.id.btnMain)
        btnSecond = findViewById(R.id.btnSecond)
        lifecycle.addObserver(MyLifeCycleObserver("ThirdActivity"))
        btnMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btnSecond.setOnClickListener {
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
            "ThirdActivity -> $mensaje",
            duracion
        ).show()
    }
}
