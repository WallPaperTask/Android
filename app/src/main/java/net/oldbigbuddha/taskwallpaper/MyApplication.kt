package net.oldbigbuddha.taskwallpaper

import android.app.Application
import android.util.Log
import io.realm.Realm

class MyApplication: Application() {
    override fun onCreate() {
        Realm.init(this)
        super.onCreate()
    }
}