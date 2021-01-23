package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "observers_table")
data class Observers (
    @ColumnInfo(name = "Second_Observer")
    var Second_Obserber_Name: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? =null

    override fun toString(): String {
        return this.Second_Obserber_Name
    }
}