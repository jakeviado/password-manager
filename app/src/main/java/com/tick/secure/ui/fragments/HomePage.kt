package com.tick.secure.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.tick.secure.R

class HomePage : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_page, container, false)

        drawerLayout = view.findViewById(R.id.drawer_layout)
        navView = view.findViewById(R.id.sidebar_nav_view)
        val sidebarButton: ImageButton = view.findViewById(R.id.sidebar_button)

        sidebarButton.setOnClickListener {
            if (drawerLayout.isDrawerOpen(navView)) {
                drawerLayout.closeDrawer(navView)
            } else {
                drawerLayout.openDrawer(navView)
            }
        }

        setupNavigationView()

        return view
    }

    private fun setupNavigationView() {
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> navigateToFragment(HomePage())
                R.id.nav_profile -> navigateToFragment(HomePage())
                R.id.nav_settings -> navigateToFragment(HomePage())
            }
            drawerLayout.closeDrawer(navView)
            true
        }
    }

    private fun navigateToFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
