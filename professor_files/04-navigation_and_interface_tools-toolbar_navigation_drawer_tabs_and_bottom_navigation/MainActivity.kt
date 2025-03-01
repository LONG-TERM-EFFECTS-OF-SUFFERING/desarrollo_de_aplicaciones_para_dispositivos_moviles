package com.example.clase5

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.clase5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupToolbar()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_contextual, menu)
        return true
    }

    private fun setupToolbar() {
        val toolbar = binding.contentToolbar.toolbar
        setSupportActionBar(toolbar)
        setupDrawer(toolbar)
        toolbar.title = "Activity Uno"
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu1 -> {
                //Tarea a realizar
                    true
                }

                R.id.menu2 -> {
                    //Tarea a realizar
                    true
                }

                else -> false
            }
        }

    }

    private fun setupDrawer(toolbar: Toolbar) {

        val drawerLayout = binding.drawerLayout
        val navView = binding.navView
        navView.itemIconTintList = null //para que aplique el color original de los iconos
        // para implementar un botón de navegación en el toolbar
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer
        )
        // Aplica el color a tu Drawable
        toggle.drawerArrowDrawable.color = ContextCompat.getColor(this,R.color.white)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()//permite mostrar el icono amburguesa

        // Configurar el listener para los elementos del Navigation Drawer
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_item1 -> {
                    startActivity(Intent(this, MainActivity2::class.java))
                    drawerLayout.closeDrawer(navView)//para cerra el layout del drawer
                    true
                }

                R.id.nav_item2 -> {
                    Toast.makeText(this, "Opcion 2", Toast.LENGTH_LONG).show()
                    drawerLayout.closeDrawer(navView)
                    true
                }
                else -> false
            }
        }

    }


}