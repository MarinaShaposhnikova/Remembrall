package com.meier.marina.viewpager


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meier.marina.base.Navigator
import com.meier.marina.listremembrall.R
import kotlinx.android.synthetic.main.fragment_view_pager.*
import org.koin.android.ext.android.inject


class ViewPagerFragment : Fragment() {

    val navigator: Navigator by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pager.adapter = RemembrallPagerAdapter(childFragmentManager, requireContext().resources)

        buttonDetails.setOnClickListener {
            navigator.navigate(ListDestination(view))
        }
    }
}
