package com.appdevgenie.wikipedia.activities

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi
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

        /*val wikiPageJson = intent.getStringExtra("page")
        Toast.makeText(this, wikiPageJson, Toast.LENGTH_LONG).show()
        currentPage = Gson().fromJson<WikiPage>(wikiPageJson, WikiPage::class.java)
        web_view?.webViewClient = object : WebViewClient(){

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return true
            }
        }

        web_view?.loadUrl(currentPage!!.fullurl)*/

        val wikiPageJson = intent.getStringExtra("page")
        //Toast.makeText(this, wikiPageJson, Toast.LENGTH_LONG).show()
        currentPage = Gson().fromJson<WikiPage>(wikiPageJson, WikiPage::class.java)
        web_view?.webViewClient = MyWebViewClient(this)
        web_view?.loadUrl(currentPage!!.fullurl)

    }

    class MyWebViewClient internal constructor(private val activity: Activity) : WebViewClient() {

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString();
            view?.loadUrl(url)
            return true
        }

        override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
            webView.loadUrl(url)
            return true
        }

        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Toast.makeText(activity, "Got Error! $error", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true;
    }
}