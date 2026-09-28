package com.example.navegacionpermisos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
// Importacones para hacer funcionar el codigo
import android.widget.Button
import android.widget.EditText
import android.util.Log
import android.content.Intent
class MainActivity : AppCompatActivity() {
    
    private lateinit var etTexto: EditText
    private lateinit var btnEnviar: Button
    private lateinit var btnPermiso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Imprimir un log en la terminal (logcat)
        Log.d("MainActivity", "onCreate ejecutado")
        // Llamar a la funcion para rescatar los elementos de la UI
        initViews()
        // llamar la funcion para estar atento a las acciones de los elementos de la UI
        setupListeners()
    }

    override fun onStart() {
        super.onStart()
        // Imprimir un log en la terminal (logcat)
        Log.d("MainActivity", "onStart ejecutado")
    }

    // Funcion que va a ir a busar los elementos de la UI
    private fun initViews() {
        etTexto = findViewById(R.id.etTexto) // Establee el  ampo editante en el texto
        btnEnviar = findViewById(R.id.btnEnviar) // Establece boton para enviar data a Detalle
        btnPermiso = findViewById(R.id.btnPermiso) // Boton que pide un permiso de telefono
    }

    // Gestionar los eventos de eschucha en caso de que el usuario interactue con la IU
    private fun setupListeners() {
        btnEnviar.setOnClickListener {
            val textoEnviado = etTexto.text.toString()

            if (textoEnviado.isNotEmpty()) {
                val intent = Intent(this, DetalleActivity::class.java)
                intent.putExtra("DATO_ENVIADO", textoEnviado)
                startActivity(intent)
            } else {
                // Mostrar mensaje si está vacío
                etTexto.error = "Ingresa un texto"
            }
        }
    }
}

