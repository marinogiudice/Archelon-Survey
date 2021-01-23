package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sector_table")
data class BeachSector (@PrimaryKey @ColumnInfo(name = "name") var Name: String) {

    override fun toString(): String {
        return this.Name
    }
}