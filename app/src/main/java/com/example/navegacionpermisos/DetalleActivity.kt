package com.example.navegacionpermisos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class DetalleActivity : AppCompatActivity() {

        private lateinit var tvDatoRecibido: TextView

        private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        setupListeners()
        mostrarDatoRecibido()
    }
    // Ir a buscar los elementos de la UI
    private fun initViews() {
        tvDatoRecibido = findViewById(R.id.tvDatoRecibido)
        btnVolver = findViewById(R.id.btnVolver)
    }
    // Escuchar los elementos de boton volver
    private fun setupListeners() {
        btnVolver.setOnClickListener {
            finish() // Cierra esta Activity y vuelve a la anterior
        }
    }

    private fun mostrarDatoRecibido() {
        val datoRecibido = intent.getStringExtra("DATO_ENVIADO")
        if (datoRecibido != null) {
            tvDatoRecibido.text = "Dato recibido: $datoRecibido"
        } else {
            tvDatoRecibido.text = "No se recibió ningún dato"
        }
    }
}