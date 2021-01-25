
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
 * This is not meant to be a full set of tests. For simplicity, most of your samples do not
 * include tests. However, when building the Room, it is helpful to make sure it works before
 * adding the UI.
 */

@RunWith(AndroidJUnit4::class)
class ArchelonDatabaseTest {

    private lateinit var archelonDao: ArchelonDao
    private lateinit var db: ArchelonDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, ArchelonDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        archelonDao = db.archelonDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetUser() {
        val user = User("marino.g83@gmail.com","Bottoncino1")
        archelonDao.insertUser(user)
        val user2 = archelonDao.getUser("marino.g83@gmail.com")
        assertThat(user2.get(0),equalTo(user))
    }

    fun insertAndGetBeach() {
        val beach = Beach("Vathi")
        archelonDao.insertBeach(beach)
        val beach2 = archelonDao.getAllBeach()
        assertThat(beach2?.value?.get(0),equalTo(beach))
    }

}
