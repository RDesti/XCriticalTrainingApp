package com.example.xcriticaltrainingapp.dataBase.DAO

import androidx.room.*
import com.example.xcriticaltrainingapp.dataBase.entities.ProjectDb

@Dao
interface ProjectDbDao {
    @Query("SELECT * FROM projectDb")
    fun getProjects(): List<ProjectDb>?

    @Query("SELECT * FROM projectDb WHERE id = :projectId")
    fun getProjectById(projectId: Int):ProjectDb

    @Query("DELETE FROM projectDb WHERE id = :projectId")
    fun deleteProjectById(projectId: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProject(project: ProjectDb)

    @Update
    fun updateProjectById(project: ProjectDb)
}