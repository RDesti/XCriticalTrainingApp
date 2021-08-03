package com.example.xcriticaltrainingapp

import com.example.xcriticaltrainingapp.dataBase.DAO.ProjectDbDao
import com.example.xcriticaltrainingapp.dataBase.entities.ProjectDb
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val projectDbDao: ProjectDbDao) {

    fun addProject(projectDb: ProjectDb): Unit = projectDbDao.addProject(projectDb)

    fun deleteProject(id: Int) = projectDbDao.deleteProjectById(id)

    fun getProjects() = projectDbDao.getProjects()

    fun getProjectById(id: Int) = projectDbDao.getProjectById(id)

    fun updateProject(projectDb: ProjectDb) = projectDbDao.updateProjectById(projectDb)
}