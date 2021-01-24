package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Wind Entity data class
 * Defines The Structure of The Room DB table "wind_table"
 * Only one column intensity.
 * intensity as PrimaryKey
 * Overrides toString()
 */

@Entity(tableName = "wind_table")
data class Wind (
    @PrimaryKey @ColumnInfo(name = "wind_intensity") var intensity: String) {

    //returns the String value intensity
    override fun toString(): String {
        return this.intensity
    }
}