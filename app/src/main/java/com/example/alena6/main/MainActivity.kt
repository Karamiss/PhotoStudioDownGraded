package com.example.alena6.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.alena6.MyApplication
import com.example.alena6.R
import com.example.alena6.databinding.ActivityMainBinding
import com.example.alena6.magazine.domen.model.ItemModel
import com.example.alena6.magazine.domen.model.itemModel
import com.example.alena6.viewmodel.PostRequestViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: PostRequestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (application as MyApplication).viewModel

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.сontainer_view) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        itemModel.add(ItemModel(R.drawable.photo_pechat, "Фотопечать"))
        itemModel.add(ItemModel(R.drawable.pechat_na_suvenirah, "Печать на сувенирах"))
        itemModel.add(ItemModel(R.drawable.pechat_poligraf, "Печать полиграфии"))
        itemModel.add(ItemModel(R.drawable.pechat_document, "Печать документов"))
        itemModel.add(ItemModel(R.drawable.order, "Произвольный заказ"))
    }
}