package com.monscheinalexandre.github.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.monscheinalexandre.github.R
import com.monscheinalexandre.github.domain.model.RepoShort

class DetailAdapter(context: Context) :
    RecyclerView.Adapter<DetailAdapter.ViewHolder>() {

    private val repos: ArrayList<RepoShort> = ArrayList()

    private val inflater = LayoutInflater.from(context)

    override fun getItemCount() = repos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_repo, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    fun setData(repos: List<RepoShort>?) {
        this.repos.clear()

        repos?.let {
            this.repos.addAll(repos)
        }

        notifyDataSetChanged()

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name: TextView = view.findViewById(R.id.name_detail)
        private val description: TextView = view.findViewById(R.id.description_detail)
        private val langage: TextView = view.findViewById(R.id.langage_detail)
        private val forks: TextView = view.findViewById(R.id.forks_detail)
        private val watchers: TextView = view.findViewById(R.id.watchers_detail)

        fun bind(repoShort: RepoShort) {
            name.text = repoShort.name
            description.text = repoShort.description
            langage.text = repoShort.langage
            forks.text = repoShort.forks.toString()
            watchers.text = repoShort.watchers.toString()
        }

    }
}