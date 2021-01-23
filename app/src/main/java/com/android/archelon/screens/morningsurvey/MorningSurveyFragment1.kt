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
 */

class MorningSurveyFragment1 : Fragment() {
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

        /*  The following code is used to handle the navigation between fragments using the support fragment manager.

            an onClick listener is set on the previous and the next button.
            The listener of the startSurveyButton button initiate and commit a new transaction "replace", by the method commit
            of the supportFragmentManager.
            The transaction replaces the current fragment with MorningSurveyFragment2, in
            fragment_container_view, of MainActivity walking the User to the second screen of "Morning Survey".
            The transaction is added to the BackStack. */
        val beachSpinner=binding.beachSpinner
        val sectorSpinner=binding.beachSectorSpinner
        val timeStampText=binding.timeStampView
        timeStampText.text=archelonViewModel.getTimeStamp()

        archelonViewModel.beaches!!.observe(viewLifecycleOwner,Observer {
            val beachSpinnerAdapter=ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            beachSpinner.adapter=beachSpinnerAdapter
            beachSpinner.prompt="Select Beach"
        })


        archelonViewModel.allBeachSector!!.observe(viewLifecycleOwner,Observer {
            val sectorSpinnerAdapter=ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item,it)
            sectorSpinner.adapter=sectorSpinnerAdapter
        })

        binding.startNewSurveyButton.setOnClickListener {
            if(beachSpinner.selectedItem!=null) {
                archelonViewModel.setBeachSurvey(beachSpinner.selectedItem)
                if(sectorSpinner.selectedItem!=null) {
                    archelonViewModel.setSectorSurvey(sectorSpinner.selectedItem)
                    requireActivity().supportFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<MorningSurveyFragment2>(R.id.fragment_container_view)
                        addToBackStack("MorninSurvey1")
                    }
                }else {
                    Toast.makeText(activity, "Please Set Beach Sector", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(activity, "Please Set Beach", Toast.LENGTH_SHORT).show();
            }

            }
        binding.previousButton.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
        return binding.root
    }







        /*
        The listener of the previous button calls the popBackStack method of the supportFragmentManager to
         walk the user to the previous screen, eliminating one transaction from the backStack.  */





}
