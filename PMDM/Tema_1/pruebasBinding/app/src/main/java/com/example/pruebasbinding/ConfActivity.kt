package com.example.pruebasbinding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.telephony.PhoneNumberUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pruebasbinding.databinding.ActivityConfBinding

class ConfActivity : AppCompatActivity() {
    // Para enlazar views con este activity
    // Para acceder a cada elemento de activity usamos confBinding.
    private lateinit var confBinding: ActivityConfBinding

    // Este atributo gestiona todas las preferencias compartidas
    private lateinit var sharedFile: SharedPreferences
    private lateinit var nameSharedPhone: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Para inflar la vista
        confBinding = ActivityConfBinding.inflate(layoutInflater)
        // Cargar el root en la vista para cargar todas la views
        setContentView(confBinding.root)

        enableEdgeToEdge()
        // setContentView(R.layout.activity_conf)
        ViewCompat.setOnApplyWindowInsetsListener(confBinding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initPreferedShare()
        start()
    }

    private fun initPreferedShare() {
        val sharedFile = "shared_file";
        this.nameSharedPhone = "phone_number"

        this.sharedFile = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
    }


    private fun start() {
        // Comprueba que el string existe en el sharedpreferences
        val sharedPhone: String? = sharedFile.getString(nameSharedPhone, null)

        sharedPhone?.let {
            startMainActivity(it)
        }

        confBinding.btnConf.setOnClickListener {
            val numberPhone = confBinding.editPhone.text.toString()
            if (numberPhone.isEmpty())
                Toast.makeText(this, "Debes introducir un telefono valido", Toast.LENGTH_LONG)
                    .show()
            else
                startMainActivity(numberPhone)
        }
    }

    private fun startMainActivity(phone: String) {
        // El @ConfActivity es para asegurar que el this es el contexto de este activity
        val intent = Intent(this@ConfActivity, MainActivity::class.java)
        intent.apply {
            putExtra("phone", phone)
            // Ese flag no volverá a crear una instancia del intent cada vez que se cambie de pantalla
            // Esto hace que no cambien las instancias
            addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
        }
        startActivity(intent)
    }
}