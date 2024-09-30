package com.example.lab_week_05

import android.view.View
import androidx.fragment.app.Fragment
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.fragment.findNavController

open class BaseAuthFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser
        if (currentUser == null) {
            redirectToLogin()
        } else if (isUserBlocked()) {
            redirectToLogin()
        }
    }
    private fun isUserBlocked(): Boolean {
        return false
    }
    private fun redirectToLogin() {
        findNavController().navigate(R.id.loginFragment)
    }
}
