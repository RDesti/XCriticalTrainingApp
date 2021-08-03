package com.example.xcriticaltrainingapp

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectService @Inject constructor() {
    @Inject
    lateinit var list: Repository
}