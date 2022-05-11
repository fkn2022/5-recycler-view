package com.example.recyclerview

import android.app.Application
import android.util.Log

class RecyclerApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("RecyclerProject", "I'm an application")
    }
}