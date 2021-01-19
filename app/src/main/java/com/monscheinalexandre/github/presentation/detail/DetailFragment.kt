package com.monscheinalexandre.github.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.monscheinalexandre.github.R

class DetailFragment : Fragment() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: DetailViewModel by viewModels()

    companion object {
        private const val KEY_ID = "key_id"

        fun newInstance(id: String): DetailFragment {
            val bundle = Bundle()
            bundle.putString(KEY_ID, id)

            val fragment = DetailFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    private lateinit var adapter: DetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar_repos)
        recyclerView = view.findViewById(R.id.recycler_view_detail)

        adapter = DetailAdapter(requireContext())
        recyclerView.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner, ::updateState)
        arguments?.getString(KEY_ID)?.let { viewModel.findRepo(it) }

    }

    private fun updateState(state: DetailState) {
        when (state) {
            is DetailState.ErrorState -> {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
            }
            is DetailState.LoadingState -> {
                progressBar.isVisible = true
            }
            is DetailState.SuccessState -> {
                progressBar.isVisible = false
                adapter.setData(state.repos)
            }
        }
    }
}