package com.example.examenpractico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.examenpractico.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val datos = intent.extras
        binding.tvInfo.text
        var str = """Datos
            Nombre: ${datos?.get("Nombre")}
            Apellidos: ${datos?.get("Apellidos")}
            Calle: ${datos?.get("Calle")}
            Sexo: ${datos?.get("Sexo")}
            Asignaturas: ${datos?.get("Asiganturas")}
            """.trimIndent()
        binding.tvInfo.text = str
        binding.btnVolver2.setOnClickListener {
            onBackPressed() }
    }
}