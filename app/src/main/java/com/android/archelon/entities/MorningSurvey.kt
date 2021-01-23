package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "morning_survey_table")
data class MorningSurvey(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Long ?,

    @ColumnInfo(name = "user")
    var User: String?,

    @ColumnInfo(name = "beach")
    var Beach: String?,

    @ColumnInfo(name = "sector")
    var Sector: String?,

    @ColumnInfo(name = "timestamp")
    var Timestamp: String?,

    @ColumnInfo(name = "leader")
    var Leader: String?,

    @ColumnInfo(name = "sec_obs")
    var Second: String?,

    @ColumnInfo(name = "sky")
    var Sky: String?,

    @ColumnInfo(name = "precipitation")
    var Precipitation: String?,

    @ColumnInfo(name = "wind")
    var Wind: String?

)