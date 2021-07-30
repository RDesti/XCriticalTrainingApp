package com.example.xcriticaltrainingapp.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticaltrainingapp.BottomNavActivity
import com.example.xcriticaltrainingapp.R
import com.example.xcriticaltrainingapp.databinding.FragmentDashboardBinding


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //(activity as BottomNavActivity?)!!.supportActionBar!!.hide()
        //(activity as BottomNavActivity?)!!.setSupportActionBar(binding.toolbarAddProject)

        (activity as BottomNavActivity?)!!.supportActionBar!!.setHomeButtonEnabled(false)
        (activity as BottomNavActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
        (activity as BottomNavActivity?)!!.supportActionBar!!.setIcon(R.drawable.ic_arrowleft)

        setHasOptionsMenu(true)

        //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})

        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.toolbar_add_project_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        (activity as BottomNavActivity?)!!.supportActionBar!!.setIcon(R.drawable.ic_list)
        _binding = null
    }
}