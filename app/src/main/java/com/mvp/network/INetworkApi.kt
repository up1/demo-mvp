package com.mvp.network

import com.mvp.data.PostData
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkApi {

    @GET(Endpoints.posts)
    fun getAllPosts(): Observable<List<PostData>>
}