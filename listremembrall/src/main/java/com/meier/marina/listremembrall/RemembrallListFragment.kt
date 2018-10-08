package com.meier.marina.listremembrall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.LinearLayoutManager
import com.meier.marina.base.DiffCallback
import com.meier.marina.base.baseStateObserver
import com.meier.marina.data.Remembrall
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.architecture.ext.viewModel

class RemembrallListFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = RemembrallListFragment()
    }

    private val viewModel by viewModel<RemembrallListViewModel>()
    private lateinit var remembrallListAdapter: RemembrallListAdapter

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        remembrallListAdapter = RemembrallListAdapter(
            AsyncDifferConfig.Builder<Remembrall>(DiffCallback<Remembrall>()).build()
        )
        listRemembrall.layoutManager = LinearLayoutManager(requireContext())
        listRemembrall.adapter = remembrallListAdapter

        viewModel.stateLV.observe(this, baseStateObserver(progress))

        viewModel.data.observe(this, Observer {
            val list = it
            remembrallListAdapter.submitList(list)
        })
    }
}
