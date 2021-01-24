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
 * Conditions at the "step2" of The Survey.
 * Uses DataBinding
 * Extends the Fragment class.
 */

class MorningSurveyFragment2 : Fragment() {
    //instantiate a ViewModel if is not been created yet.
    //use the existing one otherwise
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

        //some variables are declared to holds references to the spinners
        var windSpinner = binding.windSpinner
        var precipitationSpinner = binding.precipitationSpinner
        var skySpinner = binding.skySpinner
        var leadersSpinner = binding.leadersSpinner
        var observersSpinner = binding.observersSpinner

        //The spinners are populated as required picking the data observing the livedata of the ViewModel
        archelonViewModel.allLeaders!!.observe(viewLifecycleOwner, Observer {
            var leadersSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            leadersSpinner.adapter=leadersSpinnerAdapter
            leadersSpinner.prompt="Select Survey Leader"
        })

        archelonViewModel.allObservers!!.observe(viewLifecycleOwner, Observer {
            var observersSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            observersSpinner.adapter=observersSpinnerAdapter
            observersSpinner.prompt="Select 2nd Observer"
        })

        archelonViewModel.allSky!!.observe(viewLifecycleOwner, Observer {
            var skySpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            skySpinner.adapter=skySpinnerAdapter
            skySpinner.prompt="Select Sky Condition"
        })

        archelonViewModel.allPrecipitation!!.observe(viewLifecycleOwner, Observer {
            var precipitationSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            precipitationSpinner.adapter=precipitationSpinnerAdapter
            precipitationSpinner.prompt="Select Weather Precipitation"
        })

        archelonViewModel.allWind!!.observe(viewLifecycleOwner, Observer {
            var windSpinnerAdapter= ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            windSpinner.adapter=windSpinnerAdapter
            windSpinner.prompt="Select Wind Intensity"
        })

        /* When the user press the next button
           The values of the spinners are checked to avoid null references.
          if the values are not null the values are passed to the ViewModel
          to populate the morningSurvey Object

        */
        binding.ms2Next.setOnClickListener {
            if(leadersSpinner.selectedItem!=null) {
                archelonViewModel.setLeadersSurvey(leadersSpinner.selectedItem)
                if(observersSpinner.selectedItem!=null) {
                    archelonViewModel.setObserversSurvey(observersSpinner.selectedItem)
                    if(skySpinner.selectedItem!=null) {
                        archelonViewModel.setSkySurvey(skySpinner.selectedItem)
                        if(precipitationSpinner.selectedItem!=null) {
                            archelonViewModel.setPrecipitationSurvey(precipitationSpinner.selectedItem)
                            if(windSpinner.selectedItem!=null) {
                                archelonViewModel.setWindSurvey(windSpinner.selectedItem)
                                //if all the checks are succesfull a new fragmentManager transanction is istantiate and execute by commit.
                                // The current fragment is replaced by MorningSurveyFragment3, the transaction is added to the backstack.
                                requireActivity().supportFragmentManager.commit {
                                    setReorderingAllowed(true)
                                    replace<MorningSurveyFragment3>(R.id.fragment_container_view)
                                    addToBackStack("MorningSurvey2")
                                }
                            } else {
                                Toast.makeText(activity, "Please Set Wind", android.widget.Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(activity, "Please Set Precipitation", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(activity, "Please Set Sky", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(activity, "Please Set Leaders", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(activity, "Please Set Observers", Toast.LENGTH_SHORT).show();
            }
        }

        /*
        The listener of the previous button calls the popBackStack method of the supportFragmentManager to
         walk the user to the previous screen, eliminating the last transaction from the backStack.  */

        binding.ms2PreviousButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        /*  The listener of the cancel button calls the popBackStack method of the supportFragmentManager  to empty the backStack and
            create a new transaction to walk the User back to the MainMenu screen. */

        binding.ms2Cancel.setOnClickListener {
            archelonViewModel.cancel()
            requireActivity().supportFragmentManager.popBackStack("MainMenu", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            requireActivity().supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }

}
