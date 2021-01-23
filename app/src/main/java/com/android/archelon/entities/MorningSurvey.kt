package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "morning_survey_table")
data class MorningSurvey(

    @ColumnInfo(name = "user")
    var User: Long?,

    @ColumnInfo(name = "beach")
    var Beach: String?,

    @ColumnInfo(name = "sector")
    var Sector: String?,

    @ColumnInfo(name = "timestamp")
    var Timestamp: Long?,

    @ColumnInfo(name = "leader")
    var Leader: Long?,

    @ColumnInfo(name = "sec_obs")
    var Second: Long?,

    @ColumnInfo(name = "sky")
    var Sky: String?,

    @ColumnInfo(name = "precipitation")
    var Precipitation: String?,

    @ColumnInfo(name = "wind")
    var Wind: String?

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Long =0L
}