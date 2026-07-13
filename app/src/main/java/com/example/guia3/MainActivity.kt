
package com.example.guia3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btnAbrir: Button
    private lateinit var btnIncrementar: Button
    private lateinit var tvContador: TextView
    private var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAbrir = findViewById(R.id.btnAbrir)
        btnIncrementar = findViewById(R.id.btnIncrementar)
        tvContador = findViewById(R.id.tvContador)
        lifecycle.addObserver(MyLifeCycleObserver("MainActivity"))
        btnAbrir.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        btnIncrementar.setOnClickListener{
            contador++
            tvContador.text = "Valor contador: $contador"
        }
        if (savedInstanceState != null) {
            contador = savedInstanceState.getInt("CONTADOR")
            tvContador.text = "Valor contador: $contador"
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
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CONTADOR", contador)
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
