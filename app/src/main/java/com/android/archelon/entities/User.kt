package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users_table")
data class User (
    @ColumnInfo(name = "email")
    var Email: String,

    @ColumnInfo(name = "password")
    var Password: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var userId: Long?=null
}



