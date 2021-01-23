package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leaders_table")
data class Leaders (
    @ColumnInfo(name = "MS_Leader")
    var MS_Leader_Name: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null

    override fun toString():String {
        return this.MS_Leader_Name
    }

}