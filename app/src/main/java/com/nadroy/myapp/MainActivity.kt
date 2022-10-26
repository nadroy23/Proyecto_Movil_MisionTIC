package com.nadroy.myapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private var edit_user: EditText?=null
    private var edit_password: EditText?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit_user = findViewById(R.id.edit_user)
        edit_password = findViewById(R.id.edit_password)
    }


    fun ingresar(btningresar: View){

        if (edit_user!!.text.toString()=="admin"){
            if (edit_password!!.text.toString()=="admin"){
                val ingreso = Intent(this,Welcome::class.java)
                startActivity(ingreso)
            }
        }else{
            val dialogo = AlertDialog.Builder(this)
                .setTitle("¡Alerta!")
                .setMessage("Usuario o Contraseña incorrectos...") // R.string.variable
                .create().show()
        }




    }
}