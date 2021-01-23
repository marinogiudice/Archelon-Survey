package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "precipitation_table")
data class Precipitation (
    @PrimaryKey
    @ColumnInfo(name = "precipitation")
    var Precipitation: String

)