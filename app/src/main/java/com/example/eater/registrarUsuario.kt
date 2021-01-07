package com.example.eater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get

class registrarUsuario : AppCompatActivity() {

    lateinit var spTipoUsuario: Spinner

    lateinit var usuarioDao: UsuarioDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        spTipoUsuario = findViewById(R.id.spiner_tipoUsuario) as Spinner
        var spopciones = arrayOf("Mesero", "Cocinero", "Recepcionista")
        spTipoUsuario.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spopciones)

    }

    fun agregarUsuario(view: View) {
        val nombre = findViewById(R.id.editT_nombreUsuario) as EditText
        val apellido = findViewById(R.id.editT_apellidosUsuario) as EditText
        val email = findViewById(R.id.editT_email) as EditText
        val usuario = findViewById(R.id.editT_idUsuario) as EditText
        val tipoUser = findViewById(R.id.spiner_tipoUsuario) as Spinner
        val password = findViewById(R.id.editT_firsPasswword) as EditText
        val confirmPassword = findViewById(R.id.editT_confirmFirsPassword) as EditText

        usuarioDao = AppDataBase.getDatabase(this.applicationContext).UsuarioDao()

        val user = Usuario(null, nombre.text.toString(), apellido.text.toString(), email.text.toString(), usuario.text.toString(),
            tipoUser.selectedItem.toString(), password.text.toString())

        var t1 = Toast.makeText(this, tipoUser.selectedItem.toString(), Toast.LENGTH_SHORT)
        t1.show()

        usuarioDao.insertarUsuario(user)

        var t = Toast.makeText(this, "usuario",Toast.LENGTH_SHORT)
        t.show()

    }
}