package com.meier.marina.editor.listapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.meier.marina.editor.R
import kotlinx.android.synthetic.main.fragment_list_app.*

class ListAppFragment : Fragment() {

    private lateinit var appsAdapter: ListAppAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAppList()
    }

    private fun setupAppList() {
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
            .addCategory(Intent.CATEGORY_LAUNCHER)

        val list = requireActivity().packageManager.queryIntentActivities(mainIntent, 0)
        appsAdapter = ListAppAdapter(list)
        listApps.layoutManager = LinearLayoutManager(requireContext())
        listApps.adapter = appsAdapter
    }
}
