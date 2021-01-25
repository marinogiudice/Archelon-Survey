
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.android.archelon.dao.ArchelonDao
import com.android.archelon.database.ArchelonDatabase
import com.android.archelon.entities.Beach
import com.android.archelon.entities.User
import org.hamcrest.CoreMatchers.equalTo

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


/**
 * The Class Defines JUnit Test for the DataBase.
 * An In Memory DB is created to run the tests
 */

@RunWith(AndroidJUnit4::class)
class ArchelonDatabaseTest {

    private lateinit var archelonDao: ArchelonDao
    private lateinit var db: ArchelonDatabase
    //creates the in memory db
    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, ArchelonDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        archelonDao = db.archelonDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    //Tests that an User object is inserted in the DB correctly
    @Test
    @Throws(Exception::class)
    fun insertAndGetUser() {
        val user = User("marino.g83@gmail.com","Bottoncino1")
        archelonDao.insertUser(user)
        val user2 = archelonDao.getUser("marino.g83@gmail.com")
        assertThat(user2.get(0),equalTo(user))
    }

    //Tests that a Beach object is inserted in the DB correctly
    fun insertAndGetBeach() {
        val beach = Beach("Vathi")
        archelonDao.insertBeach(beach)
        val beach2 = archelonDao.getAllBeach()
        assertThat(beach2?.value?.get(0),equalTo(beach))
    }

}
