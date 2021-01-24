package com.android.archelon.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.*
import com.android.archelon.R
import com.android.archelon.databinding.FragmentLoginBinding
import com.android.archelon.viewmodel.ArchelonViewModel
import androidx.lifecycle.Observer
import com.android.archelon.MainActivity
import com.android.archelon.screens.mainmenu.MainFragment
import com.android.archelon.utils.validateEmail
import com.android.archelon.utils.validatePassword
import com.android.archelon.viewmodel.ArchelonViewModelFactory

/**
 * The LoginFragment class.
 * Contains all the View Elements needed to a user to login to the Archelon App.
 * Uses the ViewModel login method to let the user log-in
 * Holds a reference to the "archelonViewModel" created in the activity.
 * Use the Data Binding
 * Extends the Fragment class
 *
 */
class LoginFragment : Fragment() {
    //instantiate a ViewModel if is not been created yet.
    //use the existing one otherwise
    private val archelonViewModel: ArchelonViewModel by activityViewModels {
        ArchelonViewModelFactory((activity as MainActivity).repository)
    }

    /**
     * The function onCreateView assigns the inflates binding layout, generated from
     * the layout xml file fragment_login to the val binding.
     * Returns binding.root which contains the inflated View.
     *
     */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflates the layout
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )
        //listener for the login button
        binding.loginButton.setOnClickListener {
            val email: String = binding.emailLoginText.text.toString().trim()
            val password: String = binding.passwordLoginText.text.toString().trim()
            // the format of the data inserted from the user is validated by two helper functions
            //imported from the file utilities.kt of the packageutils
            if (validateEmail(email)) {
                if (validatePassword(password)) {
                    //if the data is valid call the login method of the ViewModel
                    archelonViewModel.login(email, password)
                    //observe the variable loggedin of the ViewModel to see if the login is been successfull
                    //display toasts as appropriate.
                    archelonViewModel.loggedIn.observe(viewLifecycleOwner, Observer {
                        if (it == false) {
                            Toast.makeText(activity, "User Not Found", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(activity, "Logged In!", Toast.LENGTH_SHORT)
                                .show();
                            /*  The following code is executed if the login is successfull.
                                It is used to handle the navigation between fragments using the support fragment manager.
                                a transaction is istantiate and execute by commit. The current fragment is replaced in the fragment container
                                by the MainFragment, containing the Main Menu View.*/
                            requireActivity().supportFragmentManager.commit {
                                setReorderingAllowed(true)
                                replace<MainFragment>(R.id.fragment_container_view)
                            }
                        }
                    })
                }
                // if the username and pass word data format are not valid some messages are displayed.
                else {
                    binding.passwordLoginText.error = "Invalid Password"
                }
            } else {
                binding.emailLoginText.error = "Invalid Email"
            }


        }
        return binding.root
    }
}







