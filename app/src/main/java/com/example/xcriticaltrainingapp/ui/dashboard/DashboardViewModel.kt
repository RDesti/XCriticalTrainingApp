package com.example.xcriticaltrainingapp.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xcriticaltrainingapp.ModelProjects
import com.example.xcriticaltrainingapp.R
import com.example.xcriticaltrainingapp.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var list: Repository

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    fun addNewProject(title: String, description: String){

        val model = ModelProjects(
            title,
            description,
            Date().time.toString(),
            R.drawable.ic_devicemobilespeaker,
            R.drawable.ic_caretright
        )
        list.addProject(model)
    }
}