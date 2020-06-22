package com.mg.assignment.mvp.presenter

import com.mg.assignment.mvp.model.ArticleModelImpl
import com.mg.assignment.mvp.view.ArticleView
import com.mg.assignment.pojo.Data

class ArticlePresenterImpl(
    var articleView: ArticleView,
    private val articleModel: ArticleModelImpl
) : ArticleModelImpl.OnLoginFinishedListener {

    fun callArticleData() {
        articleView.showLoader()
        articleModel.callArticleAPI(this)
    }

    override fun onFailure(message: String?) {
        articleView.hideLoader()
        articleView.showFailure(message)
    }

    override fun onSuccess(list: List<Data>?) {
        articleView.hideLoader()
        articleView.updateList(list)
    }
}