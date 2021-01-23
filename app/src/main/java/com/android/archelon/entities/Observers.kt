package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "observers_table")
data class Observers (
    @ColumnInfo(name = "Second_Observer")
    var secondObsName: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "second_observer_id")
    var secondObsId: Long? =null

    override fun toString(): String {
        return this.secondObsName
    }
}