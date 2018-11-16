package com.mvp.ui.posts

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.mvp.R.layout.activity_post
import com.mvp.data.PostData
import com.mvp.ui.BaseActivity
import com.mvp.ui.adapters.PostItemAdapter
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : BaseActivity(), PostView {


   private var postPresenter: PostPresenterImpl?=null


    override fun setLayout(): Int {
        return activity_post
    }

    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.getAllPosts()
    }

    private fun getPresenter(): PostPresenterImpl?{
        postPresenter = PostPresenterImpl(this, application)
        return postPresenter
    }






    override fun onStartScreen() {
    }

    override fun stopScreen() {
        postPresenter?.let {
            postPresenter!!.unbindView()
            postPresenter = null
        }

    }





    override fun showAllPosts(postList: List<PostData>) {

        Log.d("Response", "" + postList)
        rv_post_list.layoutManager = LinearLayoutManager(this)
        rv_post_list.adapter = PostItemAdapter(postList, this)
    }


}
