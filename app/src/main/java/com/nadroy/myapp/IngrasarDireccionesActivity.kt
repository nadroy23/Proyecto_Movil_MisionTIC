package com.nadroy.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class IngrasarDireccionesActivity : AppCompatActivity() {


    private var buscar_transporte: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingrasar_direcciones)

        buscar_transporte = findViewById(R.id.buscar_transporte)
    }

    fun pedir_transporte(btnpedri_transporte: View){

        if (buscar_transporte!!.text.isNotEmpty()) {
            val bundle = intent.extras
            val tex_user = bundle?.getString("user")
            val ingreso = Intent(this,ElegirTransporteActivity::class.java).apply {
                putExtra("user",tex_user)
                putExtra("dir", buscar_transporte!!.text.toString() )
            }
            startActivity(ingreso)
        }else{
            val dialogo = AlertDialog.Builder(this)
                .setTitle("¡Alerta!")
                .setMessage("Se debe especificar una Direccion, ejemplo: norte.") // R.string.variable
                .create().show()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_barra, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun OnOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.itm_buscar -> {
            Toast.makeText(this, "seleccion de buscar ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_ayuda -> {
            Toast.makeText(this, "seleccion ayuda ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_direccion -> {
            Toast.makeText(this, "seleccion de direccion ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_subir -> {
            val intento = Intent(this, Welcome::class.java)
            startActivity(intento)
            Toast.makeText(this, "seleccion subir ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_editar -> {
            Toast.makeText(this, "seleccion editar ", Toast.LENGTH_SHORT).show()
            true
        }
        R.id.itm_llamar -> {
            Toast.makeText(this, "seleccion de llamar ", Toast.LENGTH_SHORT).show()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}