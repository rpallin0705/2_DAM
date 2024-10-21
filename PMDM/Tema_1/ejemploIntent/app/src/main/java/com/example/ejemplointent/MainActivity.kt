package com.example.ejemplointent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var btnPantalla1 : Button
    private lateinit var btnPantalla2 : Button
    private lateinit var intent : Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    private fun initElementes() : Unit {
        btnPantalla1 = findViewById(R.id.btn_pantalla_1)
        btnPantalla2 = findViewById(R.id.btn_pantalla_2)

        btnPantalla1.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("bienvenida", "Bienvenido a la pantalla 1")
            }
            startActivity(intent)
        }

        btnPantalla2.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("bienvenida", "Bienvenido a la pantalla 2")
            }
            startActivity(intent)
        }
    }
}