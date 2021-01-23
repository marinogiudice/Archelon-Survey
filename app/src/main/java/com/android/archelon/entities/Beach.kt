package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beaches_table")
data class Beach (@PrimaryKey @ColumnInfo(name = "Beach") val Name: String) {

    override fun toString() : String {
        return this.Name
    }
}