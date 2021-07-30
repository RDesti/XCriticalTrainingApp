package com.example.xcriticaltrainingapp

import android.os.Bundle
import android.provider.Settings.Global.putString
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.xcriticaltrainingapp.databinding.ActivityBottomNavBinding.inflate
import com.example.xcriticaltrainingapp.databinding.ActivityMainBinding
import com.example.xcriticaltrainingapp.databinding.FragmentHomeBinding
import com.example.xcriticaltrainingapp.databinding.FragmentProjectInfoBinding
import com.example.xcriticaltrainingapp.ui.home.HomeViewModel

private const val ARG_PARAM1 = "param1"

class ProjectInfoFragment : Fragment() {

    private lateinit var projectInfoViewModel: ProjectInfoViewModel
    private var _binding: FragmentProjectInfoBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        projectInfoViewModel =
            ViewModelProvider(this).get(ProjectInfoViewModel::class.java)

        _binding = FragmentProjectInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.editTextTitleProject.setText(param1)
        return root

    }

    companion object{
        fun newInstance(param1: String) =
            ProjectInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

}