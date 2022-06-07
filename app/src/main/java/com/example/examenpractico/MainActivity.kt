package com.example.examenpractico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.examenpractico.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var Sexo = "Hombre"
    var asignaturas = "Historia"
    var Asiganturas = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getSpinner(binding.spnNacimiento)
        binding.btnEnviar.setOnClickListener { getAndSend() }

    }
    fun getAndSend(){
        val intentResult = Intent(this, ResultActivity::class.java)
        intentResult.putExtra("Nombre", binding.etNombre.text.toString())
        intentResult.putExtra("Apellidos", binding.etApellidos.text.toString())
        intentResult.putExtra("Calle", binding.etCalle.text.toString())
        intentResult.putExtra("Sexo", Sexo)
        intentResult.putExtra("Asiganturas", asignaturas)
        startActivity(intentResult)
    }
    fun getSpinner(spinner: Spinner){
        var userSelect =""
        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Nacimiento,
            android.R.layout.simple_spinner_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                userSelect = parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                userSelect = "No ha habido selección"
                Toast.makeText(this@MainActivity, userSelect, Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun onCheckBoxClicked(view: View){
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.ckArqueologia -> { if (checked) {
                    checkCategory(binding.ckArqueologia.text.toString())
                } else {
                    unCheckCategory(binding.ckArqueologia.text.toString())
                }
                }
                R.id.ckGeografia -> { if (checked) {
                    checkCategory(binding.ckGeografia.text.toString())
                } else {
                    unCheckCategory(binding.ckGeografia.text.toString())
                }
                }
                R.id.ckHistoria -> { if (checked) {
                    checkCategory(binding.ckHistoria.text.toString())
                } else {
                    unCheckCategory(binding.ckHistoria.text.toString())
                }
                }

            }
        }
    }

    fun checkCategory(str:String){
        if (!asignaturas.contains(str)) { Asiganturas.add(str) }
    }
    fun unCheckCategory(str:String){
        if (asignaturas.contains(str)) { Asiganturas.remove(str) }
    }
}

