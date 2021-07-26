package com.example.xcriticaltrainingapp

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {
    init {
        getAllProjects()
    }
    val listProjects: MutableList<ModelProjects> = mutableListOf(
        ModelProjects("proj1", "some text1", "10/10/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj2", "some text2", "10/09/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj3", "some text3", "10/08/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj4", "some text4", "10/07/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj5", "some text5", "10/06/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj6", "some text6", "10/05/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj7", "some text7", "10/04/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj8", "some text8", "10/03/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj9", "some text9", "10/02/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright),
        ModelProjects("proj10", "some text10", "10/01/21", R.drawable.ic_devicemobilespeaker, R.drawable.ic_caretright)
    )

    fun addProject(item: ModelProjects){
        listProjects.add(item)
    }

    fun deleteProject(item: Int){
        listProjects.removeAt(item)
    }

    fun getAllProjects(): MutableList<ModelProjects>{
        return  listProjects
    }
}