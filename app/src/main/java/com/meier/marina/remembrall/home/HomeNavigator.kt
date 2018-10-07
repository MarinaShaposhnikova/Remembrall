package com.meier.marina.remembrall.home

import androidx.navigation.Navigation
import com.meier.marina.base.Destination
import com.meier.marina.base.Navigator
import com.meier.marina.remembrall.R
import com.meier.marina.viewpager.ListDestination

class HomeNavigator : Navigator {
    override fun navigate(destination: Destination) {
        if (destination is ListDestination) {
            Navigation.findNavController(destination.view).navigate(R.id.action_viewPagerFragment_to_detailsFragment)
        }
    }
}
