package com.android.archelon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.android.archelon.database.ArchelonDatabase
import com.android.archelon.repository.ArchelonRepository
import com.android.archelon.viewmodel.ArchelonViewModel
import com.android.archelon.viewmodel.ArchelonViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


/**
* The MainActivity class.
* Main Instance of The application
 * A Kind of Big Container that:
 * Contains the Fragments UI Elements
 * Contains public values for database and repository
 * that can be easily accessed from the ViewModel of the fragments when needed.
 * Contains a public value for the coroutineScope used in the database creation process.
 * Creates and holds a private ViewModel Instance that will be shared in between
 * The View fragments that need it.
 *
*/

class MainActivity : AppCompatActivity() {
    //instantiate the applicationScope for the coroutines
    val applicationScope = CoroutineScope(SupervisorJob())
    //instantiate the database by lazy
    val database by lazy { ArchelonDatabase.getDatabase(this,applicationScope)}
    //instantiate the repository by lazy
    val repository by lazy { ArchelonRepository(database.archelonDao()) }
    //instantiate the ViewModel
    private val archelonViewModel: ArchelonViewModel by viewModels {
        ArchelonViewModelFactory(repository)
    }


    /**
     *  The function onCreate is called when an instance of
     *  MainActivity is created.
     *  Inflates the layout file activity_main
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
