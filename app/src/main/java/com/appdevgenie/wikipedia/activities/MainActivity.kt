package com.appdevgenie.wikipedia.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.fragments.ExploreFragment
import com.appdevgenie.wikipedia.activities.fragments.FavoriteFragment
import com.appdevgenie.wikipedia.activities.fragments.HistoryFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val exploreFragment: ExploreFragment
    private val favoriteFragment: FavoriteFragment
    private val historyFragment: HistoryFragment

    init {
        exploreFragment = ExploreFragment()
        favoriteFragment = FavoriteFragment()
        historyFragment = HistoryFragment()
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)

        when(item.itemId){
            R.id.navigation_explore -> transaction.replace(R.id.fragment_container, exploreFragment)
            R.id.navigation_favorite -> transaction.replace(R.id.fragment_container, favoriteFragment)
            R.id.navigation_history -> transaction.replace(R.id.fragment_container, historyFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        setSupportActionBar(toolbar)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, exploreFragment)
        transaction.commit()
    }
}
