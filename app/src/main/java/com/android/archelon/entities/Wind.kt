package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wind_table")
data class Wind (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Long ,

    @ColumnInfo(name = "wind_intensity")
    var Intensity: String

)