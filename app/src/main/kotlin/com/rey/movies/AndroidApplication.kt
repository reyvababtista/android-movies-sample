package com.rey.movies

import android.app.Application
import android.content.Context
import com.rey.movies.external.di.DaggerApplicationComponent

class AndroidApplication : Application() {
    companion object {
        fun appComponent(context: Context) =
            (context.applicationContext as AndroidApplication).appComponent
    }

    private val appComponent = DaggerApplicationComponent.create()
}