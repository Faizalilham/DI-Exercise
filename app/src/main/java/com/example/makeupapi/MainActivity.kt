package com.example.makeupapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.makeupapi.adapter.MakeUpAdapter
import com.example.makeupapi.databinding.ActivityMainBinding
import com.example.makeupapi.viewmodel.MakeUpViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var makeUpViewModel: MakeUpViewModel
    private lateinit var makeUpAdapter : MakeUpAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        makeUpViewModel = ViewModelProvider(this)[MakeUpViewModel::class.java]
        setContentView(binding.root)
        setRecycler()
    }

    private fun setRecycler(){
        makeUpViewModel.getAllMakeUpConfig()
        makeUpViewModel.getAllMakeUpObserve().observe(this){
            if(it != null){
                makeUpAdapter = MakeUpAdapter(it)
                binding.recyclerMakeUp.apply {
                    adapter = makeUpAdapter
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}