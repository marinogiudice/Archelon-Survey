package com.android.archelon.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * MorningSurvey Entity data class
 * Defines The Structure of The Room DB table "morning_survey_table"
 * msId as PrimaryKey
 * Contains data relative to the values inserted by the User
 * The columns (except msId and timestamp) all contains references to rows of
 * the other tables of the DB
 */

@Entity(tableName = "morning_survey_table")
data class MorningSurvey(

    @ColumnInfo(name = "user_id")
    var userId: Long?,

    @ColumnInfo(name = "beach")
    var beach: String?,

    @ColumnInfo(name = "beach_sector")
    var beachSector: String?,

    @ColumnInfo(name = "timestamp")
    var timestamp: Long?,

    @ColumnInfo(name = "leader_id")
    var leaderId: Long?,

    @ColumnInfo(name = "sec_obs")
    var secondObs: Long?,

    @ColumnInfo(name = "sky")
    var sky: String?,

    @ColumnInfo(name = "precipitation")
    var precipitation: String?,

    @ColumnInfo(name = "wind")
    var wind: String?

)
{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "msId")
    var msId: Long =0L
}