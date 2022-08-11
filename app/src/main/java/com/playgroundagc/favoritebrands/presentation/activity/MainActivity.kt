package com.playgroundagc.favoritebrands.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.playgroundagc.core.data.repository.MakeRepository
import com.playgroundagc.core.domain.usecases.ToggleFavoriteUC
import com.playgroundagc.favoritebrands.R
import com.playgroundagc.favoritebrands.databinding.ActivityMainBinding
import com.playgroundagc.favoritebrands.framework.FragmentViewModel
import com.playgroundagc.favoritebrands.framework.FragmentViewModelFactory
import com.playgroundagc.favoritebrands.framework.MakeDataSourceImpl

class MainActivity : AppCompatActivity() {

    //region Variables
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var viewModel: FragmentViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration
    //endregion

    //region Override Methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupViewModel()
        setupNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
    //endregion

    //region Setup
    private fun setupNavigation() {
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupViewModel() {
        val makeDataSource = MakeDataSourceImpl()
        val repository = MakeRepository(makeDataSource)
        val toggleFavoriteUC = ToggleFavoriteUC(repository)
        val factory = FragmentViewModelFactory(toggleFavoriteUC)

        viewModel = ViewModelProvider(this, factory)[FragmentViewModel::class.java]
    }
    //endregion
}