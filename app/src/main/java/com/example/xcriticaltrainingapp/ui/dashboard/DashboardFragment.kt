package com.example.xcriticaltrainingapp.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticaltrainingapp.BottomNavActivity
import com.example.xcriticaltrainingapp.R
import com.example.xcriticaltrainingapp.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        binding.tvSave.setOnClickListener {
            dashboardViewModel.addNewProject(
                binding.editTextTitleAddProject.text.toString(),
                binding.editTextTextScenario.text.toString()
            )

            binding.editTextTitleAddProject.text.clear()
            binding.editTextTextScenario.text.clear()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}