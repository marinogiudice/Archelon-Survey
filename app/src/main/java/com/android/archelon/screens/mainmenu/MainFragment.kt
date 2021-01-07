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
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater,
            R.layout.fragment_main,container,false)
        binding.startSurveyButton.setOnClickListener {
            activity!!.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MorningSurveyFragment1>(R.id.fragment_container_view)
                addToBackStack("MainMenu")
            }
        }
        return binding.root
    }

}
