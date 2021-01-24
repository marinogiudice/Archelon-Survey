package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * BeachSector Entity data class
 * Defines The Structure of The Room DB table "sector_table"
 * Only one column the sectorName.
 * sectorName as PrimaryKey
 * Overrides toString()
 */


@Entity(tableName = "sector_table")
data class BeachSector (@PrimaryKey @ColumnInfo(name = "Sector") val sectorName: String) {

    //returns the string value sectorName
    override fun toString(): String {
        return this.sectorName
    }
}