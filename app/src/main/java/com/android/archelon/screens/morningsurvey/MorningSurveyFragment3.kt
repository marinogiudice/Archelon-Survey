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
 * A simple [Fragment] subclass.
 */
class MorningSurveyFragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMorningSurvey3Binding>(
            inflater,
            R.layout.fragment_morning_survey3, container, false
        )
        binding.ms3PreviousButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }
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
