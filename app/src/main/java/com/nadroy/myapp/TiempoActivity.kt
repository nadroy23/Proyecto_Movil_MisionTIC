package com.nadroy.myapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class TiempoActivity : AppCompatActivity() {

    private var valor = ""
    private var tiempo_espera: TextView?=null
    private var valor_tiem: TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo)

        tiempo_espera = findViewById(R.id.tiempo_espera)
        valor_tiem = findViewById(R.id.valor_tiem)
        valor()
    }


    @SuppressLint("SetTextI18n")
    fun valor(){
        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val carro = bundle?.getString("dir")
        val dir1 = bundle?.getString("dir1")
        val dir2 = bundle?.getString("dir2")
        var valor1 = 0
        var valor2 = 0
        if (dir1.toString() == "norte"){
            valor1 = 30000
            tiempo_espera!!.setText("40")
        }else if (dir1.toString() == "sur"){
            valor1 = 50000
            tiempo_espera!!.setText("50")
        }else{
            valor1 = 40000
            tiempo_espera!!.setText("60")
        }

        if (dir2.toString() == "norte"){
            valor2 = 30000
        }else if (dir2.toString() == "sur"){
            valor2 = 50000
        }else{
            valor2 = 40000
        }
        val total = (valor1+valor2).toString()
        valor_tiem!!.setText(total)
    }

    fun no_llega(btnpedri_transporte: View){
        val dialogo = AlertDialog.Builder(this)
            .setTitle("¡Alerta!")
            .setMessage("Lo sentimos por los inconvenientes...\n" +
                    "Por Favor tener paciencia.") // R.string.variable
            .create().show()
    }

    fun fin(btnpedri_transporte: View){
        val bundle = intent.extras
        val tex_user = bundle?.getString("user")
        val carro = bundle?.getString("dir")
        val dir1 = bundle?.getString("dir1")
        val dir2 = bundle?.getString("dir2")
        val ingreso = Intent(this,PagosActivity::class.java).apply {
            putExtra("user",tex_user)
            putExtra("dir",carro)
            putExtra("dir1",dir1)
            putExtra("dir2",dir2)
            putExtra("valor",valor_tiem!!.text.toString())
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