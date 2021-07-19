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
import com.example.xcriticaltrainingapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listProj = ArrayList<ModelProjects>()
        listProj.add(ModelProjects("ghgngiuhgjg", "dfghjkiuytddfghbvgcfcdffghjk", "10/10/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghgvcjg", "dfghjkiuvgbhbvcxytdfghjk", "10/09/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghkmjnhbjg", "dfghjkiuytdfghjk", "10/08/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("gsdfghhjg", "dfghjkiuytdfghjk", "10/07/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghjkjhgfdg", "dfghjkiuytdfghjk", "10/06/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghdfghjjg", "dfghjkiuytdfghjk", "10/05/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghj,mnhgyig", "dfghjkiuytdfghjk", "10/04/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghjo;yufyuvg", "dfghjkiuytdfghjk", "10/03/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))
        listProj.add(ModelProjects("ghygokjg", "dfghjkiuytdfghjk", "10/02/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright))

        binding.rcViewProjects.hasFixedSize()
        binding.rcViewProjects.layoutManager = LinearLayoutManager(this.context)
        binding.rcViewProjects.adapter = ProjectsAdapter(listProj)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}