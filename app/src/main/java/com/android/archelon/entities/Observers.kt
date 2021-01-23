package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "observers_table")
data class Observers (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Long ,

    @ColumnInfo(name = "MS_Leader")
    var MS_Leader_Name: String,

    @ColumnInfo(name = "Second_Observer")
    var Second_Obserber_Name: String

)