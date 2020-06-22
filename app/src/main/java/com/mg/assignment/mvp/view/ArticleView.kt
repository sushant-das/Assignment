package com.mg.assignment.mvp.view

import com.mg.assignment.pojo.Data

interface ArticleView {

    fun showLoader()
    fun hideLoader()
    fun updateList(list:List<Data>?)
    fun showFailure(message: String?)
}