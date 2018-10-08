package net.oldbigbuddha.taskwallpaper.activities

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_check.*
import net.oldbigbuddha.taskwallpaper.Adapters.CheckFragmentPagerAdapter
import net.oldbigbuddha.taskwallpaper.R
import net.oldbigbuddha.taskwallpaper.hideSystemUI

class CheckActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check)
        setSupportActionBar(toolbar_check)
        toolbar_check.inflateMenu(R.menu.menu_check)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeButtonEnabled(true)
        } ?: IllegalAccessException("Toolbar cannot be null")

        val adapter = CheckFragmentPagerAdapter(supportFragmentManager)
        viewpager_check.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_check, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_save -> {
            Snackbar.make(container_check, "Saved", Snackbar.LENGTH_SHORT).show()
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI(this)
        }
    }
}
