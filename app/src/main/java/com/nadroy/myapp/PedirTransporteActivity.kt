package com.nadroy.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class PedirTransporteActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedir_transporte)
        //title = user
        //tex_user!!.text = ("Bienvenid@: "+user)
    }


    fun ingresar_direccion(btnpedri_transporte: View){
        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val ingreso = Intent(this,IngrasarDireccionesActivity::class.java).apply {
            putExtra("user",tex_user)
        }
        startActivity(ingreso)
    }

    fun cerrar(btnpedri_transporte: View){

        FirebaseAuth.getInstance().signOut()
        onBackPressed()
        val ingreso = Intent(this,MainActivity::class.java)
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