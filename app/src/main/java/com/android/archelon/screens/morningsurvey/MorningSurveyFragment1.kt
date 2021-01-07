package com.android.archelon.screens.morningsurvey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import com.android.archelon.R
import com.android.archelon.databinding.FragmentMorningSurvey1Binding

/**
 * A simple [Fragment] subclass.
 */
class MorningSurveyFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMorningSurvey1Binding>(inflater,
            R.layout.fragment_morning_survey1,container,false)
        binding.startNewSurveyButton.setOnClickListener {
            activity!!.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MorningSurveyFragment2>(R.id.fragment_container_view)
                addToBackStack("MorninSurvey1")
            }
        }
        binding.previousButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }

        return binding.root
    }

}
