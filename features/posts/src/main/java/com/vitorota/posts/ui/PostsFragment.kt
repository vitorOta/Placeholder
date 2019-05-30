package com.vitorota.posts.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vitorota.posts.R
import kotlinx.android.synthetic.main.fragment_posts.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class PostsFragment : Fragment() {

    val viewModel: PostsViewModel by viewModel()
    val adapter: PostsAdapter by lazy {
        PostsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_posts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupObservers()

        if (!viewModel.loadedOnce) {
            viewModel.initData()
        }
    }

    private fun setupView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
    }

    private fun setupObservers() {
        viewModel.showProgress.observe(this, Observer {
            recyclerView.isVisible = false
            progressBar.isVisible = true
        })

        viewModel.hideProgress.observe(this, Observer {
            recyclerView.isVisible = true
            progressBar.isVisible = false
        })


        viewModel.posts.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}