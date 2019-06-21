package com.appdevgenie.wikipedia.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.holders.CardHolder
import com.appdevgenie.wikipedia.activities.models.WikiPage

class ArticleCardRecyclerAdapter : RecyclerView.Adapter<CardHolder>(){

    val currentResults: ArrayList<WikiPage> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val cardItem = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return CardHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return currentResults.size
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {

        var page = currentResults[position]
        holder.updateWithPage(page)

    }
}