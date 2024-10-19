package com.example.listenerbotones

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// OnClickListener se implementa para el metodo SetOnClickListener
class MainActivity : AppCompatActivity(), OnClickListener {

    // Para este botón en el xml le ponemos la funcion onClick y el nombre de la función a la que llame
    // Como si fuera javascript y html
    private lateinit var buttonOnClick : Button
    private lateinit var buttonListener : Button
    private lateinit var buttonLambda : Button

    companion object {
        const val TAG = "--- SALIDA ---"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        buttonListener = findViewById(R.id.buttonListener)
        // Le pasamos el mismo botón como referencia, y SetOnClickListener llama a la función onClick
        buttonListener.setOnClickListener(this)
        buttonLambda = findViewById(R.id.buttonLambda)
        // Se le puede pasar una lambda a esta función
        buttonLambda.setOnClickListener {
            Toast.makeText(this, "Este botón saluda con una Lambda", Toast.LENGTH_LONG).show()
        }

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    private fun start() : Unit {
        buttonOnClick = findViewById(R.id.buttonOnClick)
    }

    fun darSaludo(view: View) {
            Toast.makeText(this, "Este botón saluda con onClick", Toast.LENGTH_LONG).show()
            Log. d(TAG, "hOLA")
    }

    override fun onClick(p0: View?) {
        Toast.makeText(this, "Este botón saluda con un SetOnClickListener", Toast.LENGTH_LONG).show()
    }


}