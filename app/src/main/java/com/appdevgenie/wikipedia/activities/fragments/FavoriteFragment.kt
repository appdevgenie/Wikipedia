package com.appdevgenie.wikipedia.activities.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.appdevgenie.wikipedia.R
import com.appdevgenie.wikipedia.activities.WikiApplication
import com.appdevgenie.wikipedia.activities.adapters.ArticleCardRecyclerAdapter
import com.appdevgenie.wikipedia.activities.managers.WikiManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FavoriteFragment : Fragment() {

    private var wikiManager: WikiManager? = null

    var favoriteRecycler: RecyclerView? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        wikiManager = (activity?.applicationContext as WikiApplication).wikiManager
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favorite, container, false)

        favoriteRecycler = view.findViewById(R.id.favorites_article_recycler)
        favoriteRecycler!!.layoutManager = LinearLayoutManager(context)
        favoriteRecycler!!.adapter = ArticleCardRecyclerAdapter()

        return view
    }


}
