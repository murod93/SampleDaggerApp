package uz.minmax.sampledaggerapp.ui
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.navigateUp
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import uz.minmax.sampledaggerapp.R
import uz.minmax.sampledaggerapp.app.App
import uz.minmax.sampledaggerapp.di.component.CustomerComponent

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //ui
    lateinit var drawerLayout:DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var toolbar: Toolbar
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navController:NavController

    //di
    lateinit var customerComponent: CustomerComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customerComponent = (application as App).appComponent.customerComponent().create()
        customerComponent.inject(this)

        toolbar = findViewById(R.id.toolbar)
        toolbar.apply {
            title = getString(R.string.main_title)
            setSupportActionBar(this)
        }

        setUpNavigation()
    }

    private fun setUpNavigation(){
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        navController = findNavController(R.id.nav_host_fragment)

        navigationView.setNavigationItemSelectedListener(this)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        when(id){
            R.id.nav_exit->navController.navigate(R.id.add_customer_btn, null, options)
            R.id.nav_add->navController.navigate(R.id.action_customerListFragment_to_newCustomerFragment, null, options)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)|| super.onSupportNavigateUp()
    }
}