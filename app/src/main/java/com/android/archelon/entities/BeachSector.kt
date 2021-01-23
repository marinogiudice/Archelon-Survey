package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sector_table")
data class BeachSector (@PrimaryKey @ColumnInfo(name = "Sector") val sectorName: String) {

    override fun toString(): String {
        return this.sectorName
    }
}