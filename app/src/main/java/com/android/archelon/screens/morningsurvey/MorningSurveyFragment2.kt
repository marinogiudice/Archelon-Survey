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
import com.android.archelon.databinding.FragmentMorningSurvey2Binding
import com.android.archelon.screens.mainmenu.MainFragment

/**
 * A simple [Fragment] subclass.
 */
class MorningSurveyFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentMorningSurvey2Binding>(inflater,
            R.layout.fragment_morning_survey2,container,false)
        binding.ms2Next.setOnClickListener {
            activity!!.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MorningSurveyFragment3>(R.id.fragment_container_view)
                addToBackStack("MorningSurvey2")
            }
        }
        binding.ms2PreviousButton.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack()
        }
        binding.ms2Cancel.setOnClickListener {
            activity!!.supportFragmentManager.popBackStack("MainMenu", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            activity!!.supportFragmentManager.commit() {
                replace<MainFragment>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }

}
