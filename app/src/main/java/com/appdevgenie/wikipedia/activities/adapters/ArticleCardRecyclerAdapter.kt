package com.appdevgenie.wikipedia.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.holders.CardHolder

class ArticleCardRecyclerAdapter : RecyclerView.Adapter<CardHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val cardItem = LayoutInflater.from(parent.context).inflate(R.layout.article_card_item, parent, false)
        return CardHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}