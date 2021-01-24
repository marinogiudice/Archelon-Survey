package com.android.archelon.screens.morningsurvey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.android.archelon.MainActivity

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMorningSurvey3Binding
import com.android.archelon.screens.mainmenu.MainFragment
import com.android.archelon.viewmodel.ArchelonViewModel
import com.android.archelon.viewmodel.ArchelonViewModelFactory

/**
 * The MorningSurveyFragment3 class.
 * Displays the screen "Submit Survey" where the User submits the data of the Survey.
 * Uses DataBinding
 * Extends the Fragment class
 *
 */

class MorningSurveyFragment3 : Fragment() {
    //instantiate a ViewModel if is not been created yet.
    //use the existing one otherwise
    private val archelonViewModel: ArchelonViewModel by activityViewModels {
        ArchelonViewModelFactory((activity as MainActivity).repository)
    }

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

        /*
        When the User press the previous button The listener of the previous button calls the popBackStack method of the supportFragmentManager to
         walk the user to the previous screen, eliminating the last transaction from the backStack.  */
        binding.ms3PreviousButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }


        /*  The listener of the cancel button calls the popBackStack method of the supportFragmentManager  to empty the backStack and
            create a new transaction to walk the User back to the MainMenu screen.
            the new transaction is added to the backStack*/

        binding.ms3CancelButton.setOnClickListener {
            archelonViewModel.cancel()
            requireActivity().supportFragmentManager.popBackStack(
                "MainMenu",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
            requireActivity().supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }

        /*
            When the user press the end survey button the method submit() of the viewModel is called
            followed to the cancel() method of the ViewModel.
            The user is then walked to the main menu by the SupportFragmentManager
            The current fragment is replaced by the MainFragment
         */

        binding.endSurveyBtn.setOnClickListener {
            archelonViewModel.submit()
            archelonViewModel.cancel()
            requireActivity().supportFragmentManager.popBackStack(
                "MainMenu",
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            );
            requireActivity().supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }
}
