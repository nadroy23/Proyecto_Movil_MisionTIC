package com.nadroy.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class DireccionesActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private var select2: TextView?=null
    private var dir_inicio: TextView?=null
    private var dir_destino: TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direcciones)

        select2 = findViewById(R.id.select2)

        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val carro = bundle?.getString("dir")

        dir_inicio = findViewById(R.id.dir_inicio)
        dir_destino = findViewById(R.id.dir_destino)


        db.collection("transporte").document(carro.toString()).get().addOnSuccessListener {
            select2!!.setText(it.get("carro") as String?)
        }
    }

    fun tiempo(btnpedri_transporte: View){

        if ((dir_inicio!!.text.isNotEmpty()) && (dir_destino!!.text.isNotEmpty())) {
            val bundle = intent.extras
            val tex_user = bundle?.getString("user")
            val carro = bundle?.getString("dir")
            val ingreso = Intent(this,TiempoActivity::class.java).apply {
                putExtra("user",tex_user)
                putExtra("dir",carro)
                putExtra("dir1",dir_inicio!!.text.toString())
                putExtra("dir2",dir_destino!!.text.toString())
            }
            startActivity(ingreso)
        }else{
            val dialogo = AlertDialog.Builder(this)
                .setTitle("¡Alerta!")
                .setMessage("Se debe especificar las 2 Direcciones, ejemplo: norte y sur") // R.string.variable
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