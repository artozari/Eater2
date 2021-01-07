package com.example.eater

import androidx.annotation.IntegerRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Usuario")
class Usuario (
        @PrimaryKey(autoGenerate = true)
        val id: Int?,
        @ColumnInfo(name = "nombreUsuario")
        val nombreUsuario: String,
        @ColumnInfo(name = "apellidoUsuario")
        val apellidoUsuario: String,
        @ColumnInfo(name = "emailUsuario")
        val emailUsuario: String,
        @ColumnInfo(name = "idUsuario")
        val usuario: String,
        @ColumnInfo(name = "tipoUsuario")
        val tipoUsuario: String?,
        @ColumnInfo(name = "password")
        val password: String
)