package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Precipitation Entity data class
 * Defines The Structure of The Room DB table "precipitation_table"
 * Only one column precipitation.
 * precipitation as PrimaryKey
 * Overrides toString()
 */

@Entity(tableName = "precipitation_table")
data class Precipitation (@PrimaryKey @ColumnInfo(name = "precipitation") var precipitation: String) {

    //returns the String value precipitation
    override fun toString(): String {
        return this.precipitation
    }
}