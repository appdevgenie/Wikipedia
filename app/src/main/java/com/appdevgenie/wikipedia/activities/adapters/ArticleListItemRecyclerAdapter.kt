package com.appdevgenie.wikipedia.activities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.holders.CardHolder
import com.appdevgenie.wikipedia.activities.holders.ListItemHolder

class ArticleListItemRecyclerAdapter : RecyclerView.Adapter<ListItemHolder>(){


    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item, parent, false)
        return ListItemHolder(cardItem)
    }

    override fun getItemCount(): Int {
        return 15
    }


}