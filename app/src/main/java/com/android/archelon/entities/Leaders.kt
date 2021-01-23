package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leaders_table")
data class Leaders (
    @ColumnInfo(name = "Leader")
    var msLeaderName: String
)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "leader_id")
    var leaderId: Long? = null

    override fun toString():String {
        return this.msLeaderName
    }

}