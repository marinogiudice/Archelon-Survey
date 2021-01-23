package com.android.archelon.screens.morningsurvey

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import androidx.lifecycle.Observer
import com.android.archelon.MainActivity

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMorningSurvey2Binding
import com.android.archelon.screens.mainmenu.MainFragment
import com.android.archelon.viewmodel.ArchelonViewModel
import com.android.archelon.viewmodel.ArchelonViewModelFactory

/**
 * The MorningSurveyFragment2 class.
 * Displays the screen where the User insert the Observers and The Weather
 * Conditions at the begin of The Survey.
 * Uses DataBinding
 * Extends the Fragment class.
 */

class MorningSurveyFragment2 : Fragment() {
    private val archelonViewModel: ArchelonViewModel by activityViewModels {
        ArchelonViewModelFactory((activity as MainActivity).repository)
    }


    /**
     * The function onCreateView assigns the inflates binding layout, generated from
     * the layout xml file fragment_morning_survey2 to the val binding.
     * Returns binding.root which contains the inflated View.
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMorningSurvey2Binding>(inflater,
            R.layout.fragment_morning_survey2,container,false)
        val windSpinner = binding.windSpinner
        val precipitationSpinner = binding.precipitationSpinner
        val skySpinner = binding.skySpinner

        archelonViewModel.allSky!!.observe(viewLifecycleOwner, Observer {
            val skySpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            skySpinner.adapter=skySpinnerAdapter
        })

        archelonViewModel.allPrecipitation!!.observe(viewLifecycleOwner, Observer {
            val precipitationSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            precipitationSpinner.adapter=precipitationSpinnerAdapter
        })

        archelonViewModel.allWind!!.observe(viewLifecycleOwner, Observer {
            val windSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            windSpinner.adapter=windSpinnerAdapter
        })

        /*  The following code is used to handle the navigation between fragments using the support fragment manager.

            an onClick listener is set on the previous and the next button.
            The listener of the next button initiate and commit a new transaction "replace", by the method commit
            of the supportFragmentManager. The transaction replaces the current fragment with MorningSurveyFragment3, in
            fragment_container_view, of MainActivity walking the User to the "Submit Survey Screen".
            The transaction is added to the BackStack.
         */

        binding.ms2Next.setOnClickListener {
            if(skySpinner.selectedItem!=null) {
                archelonViewModel.setSkySurvey(skySpinner.selectedItem)
                if(precipitationSpinner.selectedItem!=null) {
                    archelonViewModel.setPrecipitationSurvey(precipitationSpinner.selectedItem)
                    if(windSpinner.selectedItem!=null) {
                        archelonViewModel.setWindSurvey(windSpinner.selectedItem)
                        activity!!.supportFragmentManager.commit {
                            setReorderingAllowed(true)
                            replace<MorningSurveyFragment3>(R.id.fragment_container_view)
                            addToBackStack("MorningSurvey2")
                        }
                    } else {
                            Toast.makeText(activity, "Please Set Wind", android.widget.Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(activity, "Please Set Precipitation", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(activity, "Please Set Sky", Toast.LENGTH_SHORT).show()
            }

        }

        /*
        The listener of the previous button calls the popBackStack method of the supportFragmentManager to
         walk the user to the previous screen, eliminating one transaction from the backStack.  */

        binding.ms2PreviousButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }

        /*  The listener of the cancel button calls the popBackStack method of the support screen to empty the backStack and
            create a new transaction to walk the User back to the MainMenu screen. */

        binding.ms2Cancel.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack("MainMenu", FragmentManager.POP_BACK_STACK_INCLUSIVE)
            activity!!.supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }

}
