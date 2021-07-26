package com.example.xcriticaltrainingapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xcriticaltrainingapp.ModelProjects
import com.example.xcriticaltrainingapp.ProjectsAdapter
import com.example.xcriticaltrainingapp.R
import com.example.xcriticaltrainingapp.Repository
import com.example.xcriticaltrainingapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    @Inject
    lateinit var list: Repository

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.rcViewProjects.hasFixedSize()
        binding.rcViewProjects.layoutManager = LinearLayoutManager(this.context)
        binding.rcViewProjects.adapter = ProjectsAdapter(list.getAllProjects())
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}