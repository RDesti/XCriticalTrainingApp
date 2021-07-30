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
private const val ARG_PARAM2 = "param2"

class ProjectInfoFragment : Fragment() {

    private lateinit var projectInfoViewModel: ProjectInfoViewModel
    private var _binding: FragmentProjectInfoBinding? = null
    private val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        projectInfoViewModel =
            ViewModelProvider(this).get(ProjectInfoViewModel::class.java)

        _binding = FragmentProjectInfoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.editTextTitleProject.setText(param1)
        binding.editTextTextScenario.setText(param2)

        binding.ivBack.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        return root

    }

    companion object{
        fun newInstance(param1: String, param2: String) =
            ProjectInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}