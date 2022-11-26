package com.nadroy.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class PagosActivity : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    private var valor: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagos)

        valor = findViewById(R.id.valor)

        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val dir = bundle?.getString("dir")
        val dir1 = bundle?.getString("dir1")
        val dir2 = bundle?.getString("dir2")
        val valort = bundle?.getString("valor")

        valor!!.setText(valort.toString())

    }

    fun pagos(btnpedri_transporte: View){

        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val dir = bundle?.getString("dir")
        val dir1 = bundle?.getString("dir1")
        val dir2 = bundle?.getString("dir2")
        val valort = bundle?.getString("valor")
        var carro = ""
        db.collection("transporte").document(dir.toString()).get().addOnSuccessListener {
            carro = (it.get("carro") as String?).toString()
        }

        db.collection("historial").document(tex_user.toString()).set(
            hashMapOf("correo" to tex_user.toString(),
                "transporte" to carro,
                "direccion" to dir.toString(),
                "direccion_inico" to dir1.toString(),
                "direccion_fin" to dir2.toString(),
                "valor" to valort.toString()
        ))
        val ingreso = Intent(this,ServicioCompletadoActivity::class.java).apply {
            putExtra("user",tex_user)
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