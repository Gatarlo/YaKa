package fr.gatarlo.yaka

import android.app.Application
import io.realm.Realm

class YaKa : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}