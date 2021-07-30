package com.example.xcriticaltrainingapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticaltrainingapp.*
import com.example.xcriticaltrainingapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class HomeFragment : Fragment(), ProjectsAdapter.ClickListener {

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

        initRecyclerView()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.rcViewProjects.hasFixedSize()
        binding.rcViewProjects.layoutManager = LinearLayoutManager(this.context)
        binding.rcViewProjects.adapter = ProjectsAdapter(list.getAllProjects(), this)
        //right swipe delete
        val itemSwipe = object :  ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                showDialog(viewHolder)
            }
        }

        val swap = ItemTouchHelper(itemSwipe)
        swap.attachToRecyclerView(binding.rcViewProjects)
    }

    private fun showDialog(viewHolder: RecyclerView.ViewHolder) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("Delete")
        builder.setMessage("")
        builder.setPositiveButton("ok") {dialog, which ->
            val position = viewHolder.adapterPosition
            list.deleteProject(position)
            binding.rcViewProjects.adapter = ProjectsAdapter(list.getAllProjects(), this)
        }

        builder.setNegativeButton("cancel") {dialog, which ->
            val position = viewHolder.adapterPosition
            binding.rcViewProjects.adapter?.notifyItemChanged(position)

        }

        builder.show()
    }

    override fun onItemClick(model: ModelProjects) {
        val fragment: Fragment = ProjectInfoFragment.newInstance(model.titleText, model.contentText)
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        if (transaction != null) {
            activity?.supportFragmentManager!!.findFragmentByTag("home fragment")?.let {
                transaction.hide(
                    it
                )
            }
        }
        transaction?.add(R.id.recycler_container, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    companion object{
        fun newInstance() =
            HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}