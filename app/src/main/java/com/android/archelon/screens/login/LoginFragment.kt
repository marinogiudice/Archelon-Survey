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
import com.android.archelon.utils.validate_email
import com.android.archelon.utils.validate_password
import com.android.archelon.viewmodel.ArchelonViewModel
import androidx.lifecycle.Observer
import com.android.archelon.MainActivity
import com.android.archelon.screens.mainmenu.MainFragment
import com.android.archelon.viewmodel.ArchelonViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {
    private val archelonViewModel: ArchelonViewModel by activityViewModels {
        ArchelonViewModelFactory((activity as MainActivity).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login, container, false
        )

        binding.loginButton.setOnClickListener {
            val email: String = binding.emailLoginText.text.toString().trim()
            val password: String = binding.passwordLoginText.text.toString().trim()
            if (validate_email(email)) {
                if (validate_password(password)) {
                    archelonViewModel.login(email,password)
                    archelonViewModel.loggedIn.observe(this, Observer {
                        if (it == false) {
                            Toast.makeText(activity, "User Not Found", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(activity, "User Found", Toast.LENGTH_SHORT)
                                .show();
                            activity!!.supportFragmentManager.commit {
                                setReorderingAllowed(true)
                                replace<MainFragment>(R.id.fragment_container_view)

                            }
                        }
                    })
                } else {
                    binding.passwordLoginText.error = "Invalid Password"
                }
            } else {
                binding.emailLoginText.error = "Invalid Email"
            }
            //Toast.makeText(activity, "Password Error", Toast.LENGTH_SHORT)
            //  .show();


            /*  The following code is used to handle the navigation between fragments using the support fragment manager.

           The listener of the startSurveyButton button initiate and commit a new transaction "replace", by the method commit
           of the supportFragmentManager.
           The transaction replaces the current fragment with MainFragment, in
           fragment_container_view, of MainActivity walking the User to the "Main Menu" screen.
           The transaction is added to the BackStack. */
        }
        return binding.root
    }
}







