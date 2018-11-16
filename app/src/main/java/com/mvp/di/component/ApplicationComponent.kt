package com.mvp.di.component

import com.mvp.ApplicationClass
import com.mvp.di.module.AppModule
import com.mvp.di.module.NetModule
import com.mvp.ui.login.LoginPresenterImpl
import com.mvp.ui.posts.PostPresenterImpl
import dagger.Component

@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)
    fun inject(mLoginPresenterImpl: LoginPresenterImpl)
    fun inject(mPostPresenterImpl: PostPresenterImpl)

}