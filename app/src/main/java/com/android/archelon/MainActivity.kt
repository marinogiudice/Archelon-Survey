package com.android.archelon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.android.archelon.application.ArchelonApplication
import com.android.archelon.viewmodel.ArchelonViewModel
import com.android.archelon.viewmodel.ArchelonViewModelFactory


/**
* The MainActivity class.
* Main Instance of The application
 * Contains the Fragments UI Elements
*/

class MainActivity : AppCompatActivity() {
    private val archelonViewModel: ArchelonViewModel by viewModels {
        ArchelonViewModelFactory((application as ArchelonApplication).archelonRepo)
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
