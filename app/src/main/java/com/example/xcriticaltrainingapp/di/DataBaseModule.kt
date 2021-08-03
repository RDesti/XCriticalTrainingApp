package com.example.xcriticaltrainingapp.di

import android.content.Context
import com.example.xcriticaltrainingapp.dataBase.AppDataBase
import com.example.xcriticaltrainingapp.dataBase.DAO.ProjectDbDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context):AppDataBase{
        return  AppDataBase.getDataBase(context)
    }

    @Provides
    fun providePlantDao(appDatabase: AppDataBase): ProjectDbDao {
        return appDatabase.projectDao()
    }
}