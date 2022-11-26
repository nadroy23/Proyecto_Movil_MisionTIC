package com.nadroy.myapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthRegistrar
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private var edit_user: EditText?=null
    private var edit_password: EditText?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_user = findViewById(R.id.edit_user)
        edit_password = findViewById(R.id.edit_password)

        //registrar()
    }

    fun registrar(btnregistro: View){
        if ((edit_user!!.text.isNotEmpty()) && (edit_password!!.text.isNotEmpty())) {
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(edit_user!!.text.toString(),
                edit_password!!.text.toString()).addOnCompleteListener{

                if (it.isSuccessful){
                    val ingreso = Intent(this, PedirTransporteActivity::class.java).apply {
                        putExtra("user",edit_user!!.text.toString())
                    }
                    startActivity(ingreso)

                }else{
                    val dialogo = AlertDialog.Builder(this)
                        .setTitle("¡Error!")
                        .setMessage("No se pudo hacer el registro...") // R.string.variable
                        .create().show()
                }
            }
        }
        else{
            val dialogo = AlertDialog.Builder(this)
                .setTitle("¡Alerta!")
                .setMessage("Debe agragar un correo y contraseña para registrar...") // R.string.variable
                .create().show()
        }
    }


    fun ingresar(btningresar: View){
        if ((edit_user!!.text.isNotEmpty()) && (edit_password!!.text.isNotEmpty())) {
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(edit_user!!.text.toString(),
                edit_password!!.text.toString()).addOnCompleteListener{

                if (it.isSuccessful){
                        val ingreso = Intent(this, PedirTransporteActivity::class.java).apply {
                            putExtra("user",edit_user!!.text.toString())
                        }
                        startActivity(ingreso)
                }else{
                    val dialogo = AlertDialog.Builder(this)
                        .setTitle("¡Error!")
                        .setMessage("El usuario no se pudo identificar...") // R.string.variable
                        .create().show()
                }
            }
        }
        else{
            val dialogo = AlertDialog.Builder(this)
                .setTitle("¡Alerta!")
                .setMessage("Usuario o Contraseña incorrectos...") // R.string.variable
                .create().show()
        }

        /*
        if (edit_user!!.text.toString()=="admin"){
            if (edit_password!!.text.toString()=="admin"){
                val ingreso = Intent(this,PedirTransporteActivity::class.java)
                startActivity(ingreso)
            }
        }
         */

    }
/*
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

     */
}