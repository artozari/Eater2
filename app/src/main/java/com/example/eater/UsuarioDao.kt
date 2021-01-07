package com.example.eater

import androidx.room.*

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertarUsuario(Usuario: Usuario)

    @Delete
    fun eliminarUsuario(Usuario: Usuario)

    @Update
    fun actualizarUsuario(Usuario: Usuario)

    @Query("select * from Usuario")
    fun getUsuarios(): List<Usuario>

    @Query("select * from Usuario where idUsuario = :idUser and password = :pass")
    fun getLogin(idUser: String, pass: String): Boolean
}