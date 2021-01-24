package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * User Entity data class
 * Defines The Structure of The Room DB table "user_table"
 * Three Columns email,password,user_id
 * user_id as PrimaryKey
 *
 */

@Entity(tableName = "users_table")
data class User (
    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "password")
    var password: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Long?=null
}



