package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Beach Entity data class
 * Defines The Structure of The Room DB table "beaches_table"
 * Only one column the beachName.
 * BeachName as PrimaryKey
 */

@Entity(tableName = "beaches_table")
data class Beach (@PrimaryKey @ColumnInfo(name = "Beach") val beachName: String) {

    // return the String value BeachName
    override fun toString() : String {
        return this.beachName
    }
}