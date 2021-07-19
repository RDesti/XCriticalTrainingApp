package com.example.xcriticaltrainingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticaltrainingapp.ui.home.HomeFragment

class ProjectsAdapter(arrayList: ArrayList<ModelProjects>): RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {
    private var _arrayList = arrayList

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val _tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val _tvContent = view.findViewById<TextView>(R.id.tvContent)
        val _tvDate = view.findViewById<TextView>(R.id.tvDate)
        val _ivDevice = view.findViewById<ImageView>(R.id.ivDevice)
        val _ivArrow = view.findViewById<ImageView>(R.id.ivArrow)

        fun bind(modelProject: ModelProjects){
            _tvTitle.text = modelProject.titleText
            _tvContent.text = modelProject.contentText
            _tvDate.text = modelProject.date
            _ivDevice.setImageResource(modelProject.imageDevice)
            _ivArrow.setImageResource(modelProject.imageArrow)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_projects_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = _arrayList.get(position)
        holder.bind(listItem)
    }

    override fun getItemCount(): Int {
        return _arrayList.size
    }
}