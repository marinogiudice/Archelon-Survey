package com.android.archelon.screens.mainmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMainBinding
import com.android.archelon.screens.morningsurvey.MorningSurveyFragment1

/**
 * The MainMenuFragment class.
 * Displays The screen "Main Menu", Is the first screen after the user log in.
 * Uses DataBinding
 * Extends the Fragment Class
 */

class MainFragment : Fragment() {

    /**
     * The function onCreateView assigns the inflates binding layout, generated from
     * the layout xml file fragment_main to the val binding.
     * Returns binding.root which contains the inflated View.
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)

        /*  The following code is used to handle the navigation between fragments using the support fragment manager.

            The listener of the startSurveyButton button initiate and commit a new transaction "replace", by the method commit
            of the supportFragmentManager. The transaction replaces the current fragment with MorningSurveyFragment1, in
            fragment_container_view, of MainActivity walking the User to the first screen of "Morning Survey".
            The transaction is added to the BackStack. */

        binding.startSurveyButton.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MorningSurveyFragment1>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }

}
