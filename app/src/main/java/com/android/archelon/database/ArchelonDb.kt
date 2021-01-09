package com.bignerdranch.android.login.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class], version=1, exportSchema=false)
abstract class ArchelonDb: RoomDatabase() {
    abstract fun archelonDbDao(): ArchelonDbDao

    private class ArchelonDbCallBack(
        private val scope: CoroutineScope
    )   :RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { archelonDB ->
                scope.launch {
                    populateDatabase(archelonDB.archelonDbDao())
                }
            }
        }
        suspend fun populateDatabase(archelonDao: ArchelonDbDao) {
            var user = User(0L,"marino.g83@gmail.com","Bottoncino1")
            archelonDao.insert(user)
        }

    }

    companion object {
        @Volatile
        private var INSTANCE: ArchelonDb?=null

        fun getInstance(context: Context, scope: CoroutineScope) :ArchelonDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArchelonDb::class.java,
                        "archelon_database"
                    )
                        .addCallback(ArchelonDbCallBack(scope))
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}

