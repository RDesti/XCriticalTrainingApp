package com.example.xcriticaltrainingapp.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.xcriticaltrainingapp.dataBase.DAO.ProjectDbDao
import com.example.xcriticaltrainingapp.dataBase.entities.ProjectDb

@Database(entities = [ProjectDb::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract  fun projectDao(): ProjectDbDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "My DB"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }

}