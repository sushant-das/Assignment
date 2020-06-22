package com.mg.assignment.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mg.assignment.R
import com.mg.assignment.adapters.ArticleAdapter
import com.mg.assignment.mvp.model.ArticleModelImpl
import com.mg.assignment.mvp.presenter.ArticlePresenterImpl
import com.mg.assignment.mvp.view.ArticleView
import com.mg.assignment.pojo.Data
import com.mg.assignment.utils.LoaderUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ArticleView {

    private lateinit var mPresenter: ArticlePresenterImpl
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar!!.hide()
        setContentView(R.layout.activity_main)
        mPresenter = ArticlePresenterImpl(this, ArticleModelImpl())
        mPresenter.callArticleData()
        initializeAdapter()
    }

    private fun initializeAdapter() {
        rv_article.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val articleList = ArrayList<Data>()
        adapter = ArticleAdapter(articleList)
        rv_article.adapter = adapter
    }

    override fun showLoader() {
        LoaderUtil.displayProgressDialog(this)
    }

    override fun hideLoader() {
        LoaderUtil.dismissProgressDialog()
    }

    override fun updateList(list: List<Data>?) {
        if (list!!.isNotEmpty()) {
            adapter.updateList(list)
        }
    }

    override fun showFailure(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}