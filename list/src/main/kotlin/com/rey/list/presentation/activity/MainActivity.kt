package com.rey.list.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rey.list.databinding.ActivityMainBinding
import com.rey.list.external.di.DaggerListComponent
import com.rey.list.external.di.ListComponent
import com.rey.movies.AndroidApplication.Companion.appComponent

class MainActivity : AppCompatActivity() {

    lateinit var component: ListComponent
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        component = DaggerListComponent.factory().create(appComponent(this))
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}