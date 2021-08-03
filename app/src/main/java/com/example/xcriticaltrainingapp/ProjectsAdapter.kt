package com.example.xcriticaltrainingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xcriticaltrainingapp.dataBase.entities.ProjectDb

class ProjectsAdapter(list: List<ProjectDb>, clickListener: ClickListener): RecyclerView.Adapter<ProjectsAdapter.ViewHolder>() {
    private var _list = list
    private val _clickListener = clickListener

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val _tvTitle = view.findViewById<TextView>(R.id.tvTitle)
        val _tvContent = view.findViewById<TextView>(R.id.tvContent)
        val _tvDate = view.findViewById<TextView>(R.id.tvDate)
        val _ivDevice = view.findViewById<ImageView>(R.id.ivDevice)
        val _ivArrow = view.findViewById<ImageView>(R.id.ivArrow)

        fun bind(modelProject: ProjectDb?){
            if (modelProject != null) {
                _tvTitle.text = modelProject.title
            }
            if (modelProject != null) {
                _tvContent.text = modelProject.scenario
            }
            if (modelProject != null) {
                _tvDate.text = modelProject.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_projects_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = _list[position]
        holder.bind(listItem)

        holder.itemView.setOnClickListener {
            _list.let { it1 -> _clickListener.onItemClick(it1[position]) }
        }
    }

    override fun getItemCount(): Int {
        return _list.size
    }

    interface ClickListener{
        fun onItemClick(model: ProjectDb)
    }
}