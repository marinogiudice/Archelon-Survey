package com.android.archelon.database



import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*
import com.android.archelon.utils.PopulatesDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Database(entities = arrayOf(User::class,Beach::class,BeachSector::class, Precipitation::class, Sky::class, Wind::class, MorningSurvey::class) , version = 1, exportSchema = false)
abstract class ArchelonDatabase : RoomDatabase() {

    abstract fun archelonDao() : ArchelonDao

    private class ArchelonDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var archelonDao = database.archelonDao()
                    var populateDb = PopulatesDb(archelonDao)
                    populateDb.insertUser()
                    populateDb.insertBeach()
                    populateDb.insertBeach_Sector()
                    populateDb.insertPrecipitation()
                    populateDb.insertSky()
                    populateDb.insertWind()

                }
            }
        }
    }


    companion object {

        @Volatile
        private var INSTANCE: ArchelonDatabase? = null

        fun getDatabase(context: Context,scope: CoroutineScope) : ArchelonDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, ArchelonDatabase::class.java, "ARCHELON_DATABASE")
                    .addCallback(ArchelonDatabaseCallback(scope))
                    .allowMainThreadQueries()
                    .build()

                return INSTANCE!!

            }
        }

    }

}