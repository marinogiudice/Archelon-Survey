package com.android.archelon.screens.morningsurvey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.android.archelon.MainActivity

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMorningSurvey1Binding
import com.android.archelon.viewmodel.ArchelonViewModel
import com.android.archelon.viewmodel.ArchelonViewModelFactory

/**
 * The Class MorningSurveyFragment1.
 * Displays the screen "Morning Survey" the first step of "Start New Morning Survey"
 * Uses DataBinding
 * Extends the Fragment Class
 * Holds The view Elements that build the Morning Survey "step1" Screen
 */

class MorningSurveyFragment1 : Fragment() {
    //instantiate a ViewModel if is not been created yet.
    //use the existing one otherwise
    private val archelonViewModel: ArchelonViewModel by activityViewModels {
        ArchelonViewModelFactory((activity as MainActivity).repository)
    }

    /**
     * The function onCreateView assigns the inflates binding layout, generated from
     * the layout xml file fragment_morning_survey1 to the val binding.
     * Returns binding.root which contains the inflated View.
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMorningSurvey1Binding>(inflater,
            R.layout.fragment_morning_survey1,container,false)

        //some variables are declared to holds references to the spinners
        var beachSpinner=binding.beachSpinner
        var sectorSpinner=binding.beachSectorSpinner
        var timeStampText=binding.timeStampView
        //the timsestamp is obtained from the ViewModel and assigned to the holder timeStampView TextView
        binding.timeStampView.text=archelonViewModel.getTimeStamp()

        //The spinners are populated as required picking the data observing the livedata of the ViewModel
        archelonViewModel.beaches!!.observe(viewLifecycleOwner,Observer {
            var beachSpinnerAdapter=ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            beachSpinner.adapter=beachSpinnerAdapter
            beachSpinner.prompt="Select Beach"
        })


        archelonViewModel.allBeachSector!!.observe(viewLifecycleOwner,Observer {
            var sectorSpinnerAdapter=ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            sectorSpinner.adapter=sectorSpinnerAdapter
            sectorSpinner.prompt="Select Beach Sector"
        })

        /*The values of the spinners are checked to avoid null references.
          if the values are not null the values are passed to the ViewModel
          to populate the morningSurvey Object

        */
        binding.startNewSurveyButton.setOnClickListener {
            if(beachSpinner.selectedItem!=null) {
                archelonViewModel.setBeachSurvey(beachSpinner.selectedItem)
                if(sectorSpinner.selectedItem!=null) {
                    archelonViewModel.setSectorSurvey(sectorSpinner.selectedItem)
                    //if all the checks are succesfull a new fragmentManager transanction is istantiate and execute by commit.
                    // The current fragment is replaced by MorningSurveyFragment2, the transaction is added to the backstack.
                    requireActivity().supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<MorningSurveyFragment2>(R.id.fragment_container_view)
                        addToBackStack("MorninSurvey1")
                    }
                    // if the data in the spinners doesn't pass the validation
                    //some messages are displayed and the transaction is not executed
                }else {
                    Toast.makeText(activity, "Please Set Beach Sector", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(activity, "Please Set Beach", Toast.LENGTH_SHORT).show();
            }

            }
        //if the user press the previous button the last transaction is popped from the backstack of the FragmentManager
        //and the user is walked to the previous screen
        binding.previousButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root
    }







        /*
        The listener of the previous button calls the popBackStack method of the supportFragmentManager to
         walk the user to the previous screen, eliminating one transaction from the backStack.  */





}
