package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Sky Entity data class
 * Defines The Structure of The Room DB table "sky_table"
 * Only one column condition.
 * condition as PrimaryKey
 * Overrides toString()
 */

@Entity(tableName = "sky_table")
data class Sky (@PrimaryKey @ColumnInfo(name = "Sky_condition") var condition: String) {

    //returns the String value condition
    override fun toString(): String {
        return this.condition
    }
}