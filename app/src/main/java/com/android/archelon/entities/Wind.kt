package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wind_table")
data class Wind (
    @PrimaryKey @ColumnInfo(name = "wind_intensity") var intensity: String) {

    override fun toString(): String {
        return this.intensity
    }
}