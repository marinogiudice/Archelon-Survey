package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sky_table")
data class Sky (@PrimaryKey @ColumnInfo(name = "Sky_condition") var condition: String) {

    override fun toString(): String {
        return this.condition
    }
}