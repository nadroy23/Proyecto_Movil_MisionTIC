package com.nadroy.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Arrays

class ElegirTransporteActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private var selec_transp: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_elegir_transporte)

        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val zona = bundle?.getString("dir")

        selec_transp = findViewById(R.id.selec_transp)

        db.collection("transporte").document(zona.toString()).get().addOnSuccessListener {
            selec_transp!!.setText(it.get("carro") as String?)
        }
    }


    fun direcciones(btnpedri_transporte: View){
        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val zona = bundle?.getString("dir")
        val ingreso = Intent(this,DireccionesActivity::class.java).apply {
            putExtra("user",tex_user)
            putExtra("dir",zona)
        }
        startActivity(ingreso)
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