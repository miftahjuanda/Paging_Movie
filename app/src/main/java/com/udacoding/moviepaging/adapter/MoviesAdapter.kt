package com.udacoding.moviepaging.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.udacoding.moviepaging.R
import com.udacoding.moviepaging.model.ResultsItem
import kotlinx.android.synthetic.main.item_view.view.*

class MoviesAdapter :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        return MoviesHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MoviesHolder) {
            holder.bindTo(getItem(position))
        }
    }

    class MoviesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ResultsItem?) {

            itemView.tv_title.text = item?.name
            itemView.tv_desc.text = item?.description
            itemView.tv_list_type.text = item?.listType
            itemView.tv_fav_count.text = item?.itemCount.toString()
            Picasso.get().load(item?.posterPath)
                .placeholder(R.drawable.gambar1)
                .fit().centerCrop()
                .error(R.drawable.ic_warning)
                .into(itemView.iv_image)
        }
    }
}