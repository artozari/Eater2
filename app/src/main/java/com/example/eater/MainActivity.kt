package com.example.eater

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.time.Instant

class MainActivity : AppCompatActivity() {

    lateinit var usuarioDao: UsuarioDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usuarioDao = AppDataBase.getDatabase(this).UsuarioDao()

    }

    fun irARegistroUsuario(view: View) {
        val intent = Intent(this, registrarUsuario::class.java)
        startActivity(intent)
    }

    fun ingresarAlSistema(view: View) {

        val idUser = findViewById(R.id.editT_usuario) as EditText
        val pass = findViewById(R.id.editT_contasena) as EditText
        val i = idUser.text.toString()
        val p = pass.text.toString()
        val loguin = usuarioDao.getLogin(i, p)
        if(loguin){
            val int = Intent(this, Principal::class.java)
            startActivity(int)
        }
        else{
            var t = Toast.makeText(this, "El loguin es trucho, intenta otra vez", Toast.LENGTH_SHORT).show()
        }


    }
}