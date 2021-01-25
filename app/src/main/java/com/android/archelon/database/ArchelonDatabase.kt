package com.android.archelon.database



import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.android.archelon.dao.ArchelonDao
import com.android.archelon.entities.*
import com.android.archelon.utils.PopulatesDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * The ArchelonDatabase Class.
 * Defines the RoomDatabase schema
 * Uses a CallBack to populate the database on first creation.
 * Implements the Singleton Pattern in the companion object to create a new Database if no found
 * Returns the existing one otherwise.
 * I used Google android developer website as pointer:
 * https://developer.android.com/codelabs/android-room-with-a-view-kotlin#7
 */
@Database(entities = arrayOf(User::class,Beach::class,BeachSector::class, Precipitation::class, Sky::class, Wind::class, MorningSurvey::class, Leaders::class,Observers::class) , version = 1, exportSchema = false)
abstract class ArchelonDatabase : RoomDatabase() {

    abstract fun archelonDao() : ArchelonDao

    //defines a Room Callback
    private class ArchelonDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        //defines the steps to populate the db on first creation
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var archelonDao = database.archelonDao()
                    var populateDb = PopulatesDb(archelonDao)
                    populateDb.insertUser()
                    populateDb.insertBeach()
                    populateDb.insertBeachSector()
                    populateDb.insertPrecipitation()
                    populateDb.insertSky()
                    populateDb.insertWind()
                    populateDb.insertLeaders()
                    populateDb.insertObservers()

                }
            }
        }
    }


    companion object {

        @Volatile
        private var INSTANCE: ArchelonDatabase? = null
        //implemets the singleton pattern
        fun getDatabase(context: Context,scope: CoroutineScope) : ArchelonDatabase {
            //if a db instance is found
            if (INSTANCE != null) return INSTANCE!!
            //if a db instance is not found
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