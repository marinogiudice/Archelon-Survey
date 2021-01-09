package com.bignerdranch.android.login.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User(
    @PrimaryKey(autoGenerate=true)
    @ColumnInfo(name="id")
    var userId: Long = 0L,
    @ColumnInfo(name="email")
    val email: String,
    @ColumnInfo(name="password")
    val password: String)
