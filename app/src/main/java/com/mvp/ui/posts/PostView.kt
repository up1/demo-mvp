package com.mvp.ui.posts

import com.mvp.data.PostData
import com.mvp.ui.IView

interface PostView: IView {

    fun showAllPosts(postList: List<PostData>)
}