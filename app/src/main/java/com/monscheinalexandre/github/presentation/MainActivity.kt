package com.monscheinalexandre.github.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.monscheinalexandre.github.R
import com.monscheinalexandre.github.presentation.detail.DetailFragment
import com.monscheinalexandre.github.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private var container2: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        container2 = findViewById(R.id.fragment_container)

        supportFragmentManager.commit {
            add(R.id.fragment_container, SearchFragment())
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)

        return true
    }

    fun displayMovieDetail(id: String) {

        if (container2 != null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container2, DetailFragment.newInstance(id))
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, DetailFragment.newInstance(id))
                addToBackStack(null)
            }
        }
    }
}