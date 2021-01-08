package com.android.archelon.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import com.android.archelon.R
import com.android.archelon.databinding.FragmentLoginBinding
import com.android.archelon.screens.mainmenu.MainFragment

/**
 * The LoginFragment class.
 * Displays The Login Form to let the User Log in.
 * Uses DataBinding
 * Extends the Fragment class
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

        /*  The following code is used to handle the navigation between fragments using the support fragment manager.

            The listener of the startSurveyButton button initiate and commit a new transaction "replace", by the method commit
            of the supportFragmentManager.
            The transaction replaces the current fragment with MainFragment, in
            fragment_container_view, of MainActivity walking the User to the "Main Menu" screen.
            The transaction is added to the BackStack. */

        binding.loginButton.setOnClickListener {
            activity!!.supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<MainFragment>(R.id.fragment_container_view)

            }
        }
        return binding.root
    }
}
