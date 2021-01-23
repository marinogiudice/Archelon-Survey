package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beaches_table")
data class Beach (
    @PrimaryKey
    @ColumnInfo(name = "beach_name")
    var Name: String

)