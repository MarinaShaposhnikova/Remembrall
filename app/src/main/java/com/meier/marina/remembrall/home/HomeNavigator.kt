package com.meier.marina.remembrall.home

import android.os.Bundle
import androidx.navigation.Navigation
import com.meier.marina.base.Destination
import com.meier.marina.base.Navigator
import com.meier.marina.editor.CREATE
import com.meier.marina.editor.EditorConfig
import com.meier.marina.editor.KEY_EDITOR_CONFIG
import com.meier.marina.remembrall.R
import com.meier.marina.viewpager.CreateDestination

class HomeNavigator : Navigator {
    override fun navigate(destination: Destination) {
        if (destination is CreateDestination) {
            Navigation.findNavController(destination.view)
                .navigate(R.id.action_viewPagerFragment_to_editorFragment, Bundle().apply {
                    putParcelable(KEY_EDITOR_CONFIG, EditorConfig(CREATE))
                })
        }
    }
}
