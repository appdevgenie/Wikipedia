package com.appdevgenie.wikipedia.activities.holders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevgenie.wikipedia.R
import kotlinx.android.synthetic.main.article_card_item.view.*

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val articleImageView: ImageView = itemView.findViewById(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById(R.id.result_title)


}