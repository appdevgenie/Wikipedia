package com.appdevgenie.wikipedia.activities

import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.models.WikiPage
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_article_detail.*

class ArticleDetailActivity : AppCompatActivity(){

    private var currentPage: WikiPage? = null

    var web_view: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        setSupportActionBar(findViewById(R.id.toolbar));
        supportActionBar!!.setDisplayHomeAsUpEnabled(true);

        web_view = findViewById(R.id.article_detail_webview)

        val wikiPageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson<WikiPage>(wikiPageJson, WikiPage::class.java)
        web_view?.webViewClient = object : WebViewClient(){

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return true
            }
        }

        web_view?.loadUrl(currentPage!!.fullurl)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true;
    }
}