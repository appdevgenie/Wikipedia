package com.appdevgenie.wikipedia.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.holders.CardHolder
import com.appdevgenie.wikipedia.activities.holders.ListItemHolder
import com.appdevgenie.wikipedia.activities.models.WikiPage

class ArticleListItemRecyclerAdapter : RecyclerView.Adapter<ListItemHolder>(){

    val currentResults : ArrayList<WikiPage> = ArrayList()

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {

        var page = currentResults[position]
        holder.updateWithPage(page)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item, parent, false)
        return ListItemHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return currentResults.size
    }


}