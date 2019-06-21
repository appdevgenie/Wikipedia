package com.appdevgenie.wikipedia.activities

import android.app.Application
import com.appdevgenie.wikipedia.activities.managers.WikiManager
import com.appdevgenie.wikipedia.activities.providers.ArticleDataProvider
import com.appdevgenie.wikipedia.activities.repositories.ArticleDatabaseOpenHelper
import com.appdevgenie.wikipedia.activities.repositories.FavoritesRepository
import com.appdevgenie.wikipedia.activities.repositories.HistoryRepository

class WikiApplication : Application() {

    private var dbHelper: ArticleDatabaseOpenHelper? = null
    private var favoritesRepository: FavoritesRepository? = null
    private var historyRepository: HistoryRepository? = null
    private var wikiProvider: ArticleDataProvider? = null

    var wikiManager: WikiManager? = null
        private set

    override fun onCreate() {
        super.onCreate()

        dbHelper = ArticleDatabaseOpenHelper(applicationContext)
        favoritesRepository = FavoritesRepository(dbHelper!!)
        historyRepository = HistoryRepository(dbHelper!!)
        wikiProvider = ArticleDataProvider()
        wikiManager = WikiManager(wikiProvider!!, favoritesRepository!!, historyRepository!!)
    }
}