package com.android.archelon.screens.morningsurvey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMorningSurvey3Binding
import com.android.archelon.screens.mainmenu.MainFragment

/**
 * The MorningSurveyFragment3 class.
 * Displays the screen "Submit Survey" where the User submits the data of the Survey.
 * Uses DataBinding
 * Extends the Fragment class
 *
 */

class MorningSurveyFragment3 : Fragment() {

    /**
     * The function onCreateView assigns the inflates binding layout, generated from
     * the layout xml file fragment_morning_survey3 to the val binding.
     * Returns binding.root which contains the inflated View.
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMorningSurvey3Binding>(
            inflater,
            R.layout.fragment_morning_survey3, container, false
        )

        /*  The following code is used to handle the navigation between fragments using the support fragment manager

            an onClick listener is set on the previous and the cancel button.
            The listener of the previous button calls the popBackStack method of the supportFragmentManager to
            walk the user to the previous screen.  */

        binding.ms3PreviousButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }

        /*  The listener of the cancel button calls the popBackStack method of the support screen to empty the backStack and
            create a new transaction to walk the User back to the MainMenu screen. */

        binding.ms3CancelButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack(
                "MainMenu",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            );
            activity!!.supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }
}