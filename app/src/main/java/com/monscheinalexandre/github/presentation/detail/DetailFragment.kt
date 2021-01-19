package com.monscheinalexandre.github.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.monscheinalexandre.github.R

class DetailFragment: Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var langage: TextView
    private lateinit var forks: TextView
    private lateinit var watchers: TextView
    private lateinit var licence: TextView

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var adapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = view.findViewById(R.id.name)
        description = view.findViewById(R.id.description_detail)
        langage = view.findViewById(R.id.langage_detail)
        forks = view.findViewById(R.id.forks_detail)
        watchers = view.findViewById(R.id.watchers_detail)
        licence = view.findViewById(R.id.licence_detail)
        progressBar = view.findViewById(R.id.progress_bar)

        adapter = DetailAdapter(requireContext())

        viewModel.state.observe(viewLifecycleOwner, ::updateState)
    }

    private fun updateState(state: DetailState) {
        when (state) {
            is DetailState.ErrorState -> {
                progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is DetailState.LoadingState -> {
                progressBar.isVisible = true
                adapter.setData(null)
            }
            is DetailState.SuccessState -> {
                progressBar.isVisible = false
                adapter.setData(state.repos)
            }
        }
    }
}