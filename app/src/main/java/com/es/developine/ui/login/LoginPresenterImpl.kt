package com.es.developine.ui.login

import android.app.Application
import android.util.Log
import com.es.developine.ApplicationClass
import com.es.developine.network.INetworkApi
import com.google.gson.JsonElement
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class LoginPresenterImpl(var loginViewInit: LoginView, var applicationComponent: Application) : LoginPresenter {

    @Inject
    lateinit var mNetworkApi: INetworkApi

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun validateUser(userName: String, userPassword: String) {

        if (userPassword=="")
            loginViewInit.onPasswordError()

        var allPosts: Observable<JsonElement> = mNetworkApi.getAllPosts()

        allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread()).subscribe(

                { result -> Log.d("MEWAPI", "Success") },
                { error -> Log.d("MEWAPI", "Failure") }
        )
    }

    override fun peformLogin(userName: String, userPassword: String) {
        if (userName == "hammad") {
            loginViewInit.navigateToHome()
        }
    }
}