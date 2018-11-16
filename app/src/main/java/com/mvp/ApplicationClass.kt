package com.mvp

import android.app.Application
import com.mvp.di.component.ApplicationComponent
import com.mvp.di.component.DaggerApplicationComponent
import com.mvp.di.module.NetModule

open class ApplicationClass : Application() {


    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .netModule(NetModule())
                .build()

        applicationComponent.inject(this)
    }
}