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
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private lateinit var userDetail: TextView
    private lateinit var avatar: Button
    private lateinit var progressBar: ProgressBar

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_github_repositories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userDetail = view.findViewById(R.id.user_name)
        avatar = view.findViewById(R.id.user_avatar)
        progressBar = view.findViewById(R.id.progress_bar)

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        arguments?.getString(KEY_ID)?.let {
            viewModel.getUserDetail(it)
        }
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
                userDetail.text = state.user.username
                if (state.user.avatar.isNotEmpty() && state.user.avatar.isNotBlank()) {
                    Picasso.get().load(state.user.avatar).into(avatar)
                }
            }
        }
    }
}