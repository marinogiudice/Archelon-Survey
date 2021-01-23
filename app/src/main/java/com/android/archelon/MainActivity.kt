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
 * Contains the Fragments UI Elements
*/

class MainActivity : AppCompatActivity() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ArchelonDatabase.getDatabase(this,applicationScope)}
    val repository by lazy { ArchelonRepository(database.archelonDao()) }
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
