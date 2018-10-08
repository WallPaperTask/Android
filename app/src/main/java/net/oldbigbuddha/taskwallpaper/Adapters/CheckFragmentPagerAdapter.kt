package net.oldbigbuddha.taskwallpaper.Adapters

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import net.oldbigbuddha.taskwallpaper.CheckImageFragment

class CheckFragmentPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    companion object {
        const val THEME_SIZE = 5
    }

    override fun getItem(position: Int): Fragment {

        val fragment = CheckImageFragment.newInstance()
        val args = Bundle()

        when (position) {
            0 -> {
                Log.d("Fragment Page", "0")
            }

            1 -> {
                Log.d("Fragment Page", "1")
            }

            2 -> {
                Log.d("Fragment Page", "2")
            }

            3 -> {
                Log.d("Fragment Page", "3")
            }

            4 -> {
                Log.d("Fragment Page", "4")
            }

            else -> {
                Log.d("Fragment Page", "else")
            }
        }
        fragment.arguments = args
        return fragment
    }

    override fun getCount(): Int = THEME_SIZE
}