package com.android.archelon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
* The MainActivity class.
* Main Instance of The application
 * Contains the Fragments UI Elements
*/

class MainActivity : AppCompatActivity() {

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
