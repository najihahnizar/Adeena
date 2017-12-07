package ilyana.aziera.adeena

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var mDrawerLayout: DrawerLayout? = null
    private var mToggle: ActionBarDrawerToggle? = null
    private var toolbar: Toolbar? = null
    private var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MainFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()

        toolbar = findViewById<View>(R.id.toolbar)
        setSupportActionBar(toolbar)

        mDrawerLayout = findViewById<View>(R.id.drawer_layout)
        mToggle = ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        mDrawerLayout!!.addDrawerListener(mToggle!!)
        mToggle!!.syncState()
        navigationView = findViewById<View>(R.id.nav_view)
        navigationView!!.setNavigationItemSelectedListener(this)

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        ilyana.aziera.adeena.BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> {
                    selectedFragment = ilyana.aziera.adeena.MainFragment.newInstance()
                    supportActionBar!!.setTitle("Adeena:Muslimah Companion")
                }
                R.id.todo -> {
                    selectedFragment = ilyana.aziera.adeena.ToDoFragment.newInstance()
                    supportActionBar!!.setTitle("To Do List")
                }
                R.id.news -> {
                    selectedFragment = ilyana.aziera.adeena.NewsFragment.newInstance()
                    supportActionBar!!.setTitle("News")
                }
                R.id.life -> {
                    selectedFragment = ilyana.aziera.adeena.LifeFragment.newInstance()
                    supportActionBar!!.setTitle("Life")
                }
                R.id.zikr -> {
                    selectedFragment = ilyana.aziera.adeena.ZikrFragment.newInstance()
                    supportActionBar!!.setTitle("Daily Zikr and Duas")
                }
                else -> {
                    selectedFragment = ilyana.aziera.adeena.MainFragment.newInstance()
                    supportActionBar!!.setTitle("Adeena:Muslimah Companion")
                }
            }
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, selectedFragment)
            transaction.commit()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (mToggle!!.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_settings -> AlertDialog.Builder(this).setView(R.layout.fragment_setting).show()
            R.id.nav_share -> {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus")
                sendIntent.type = "text/plain"
                startActivity(sendIntent)
            }
            R.id.nav_rate -> {
                val rate = AlertDialog.Builder(this)
                rate.setCancelable(false)
                rate.setTitle("Rate Us!")
                rate.setMessage(this.getString(R.string.rate))
                rate.setPositiveButton("Rate Now") { dialog, id ->
                    //Action for "Delete".
                    dialog.dismiss()
                }
                        .setNegativeButton("No Thanks") { dialog, which ->
                            //Action for "Cancel".
                            dialog.dismiss()
                        }

                val alert = rate.create()
                alert.show()
            }
            R.id.nav_terms -> {
                val terms = AlertDialog.Builder(this).create()
                // Setting Dialog Title
                terms.setTitle("Terms and Conditions")
                // Setting Dialog Message
                terms.setMessage(this.getString(R.string.terms))
                // Setting OK Button
                terms.setButton("OK") { dialog, which -> dialog.dismiss() }
                // Showing Alert Message
                terms.show()
            }
            R.id.nav_privacy -> {
                val privacy = AlertDialog.Builder(this).create()
                // Setting Dialog Title
                privacy.setTitle("Privacy Policy")
                // Setting Dialog Message
                privacy.setMessage(this.getString(R.string.privacy_policy))
                // Setting OK Button
                privacy.setButton("OK") { dialog, which -> dialog.dismiss() }
                // Showing Alert Message
                privacy.show()
            }
            R.id.nav_contact -> AlertDialog.Builder(this).setView(R.layout.fragment_contact).show()
            R.id.nav_about -> AlertDialog.Builder(this).setView(R.layout.fragment_about).show()
        }
        mDrawerLayout = findViewById<View>(R.id.drawer_layout)
        mDrawerLayout!!.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        mDrawerLayout = findViewById<View>(R.id.drawer_layout)
        if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
        super.onBackPressed()
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}
