package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())

        val myToolbar = binding.toolbar
        val navController = this.findNavController(R.id.navHostFragment)

        val appBarConfiguration = AppBarConfiguration(navController.graph)

        myToolbar.setupWithNavController(navController, appBarConfiguration)

        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        myToolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.loginFragment) {
                navController.navigate(R.id.loginFragment)
                true
            }

            else false
        }
    }


    override fun onSupportNavigateUp(): Boolean {

        val navController = this.findNavController(R.id.navHostFragment)
        return navController.navigateUp() || super.onSupportNavigateUp()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.logout, menu)

        return super.onCreateOptionsMenu(menu)

    }

}




