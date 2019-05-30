package com.vitorota.albums.ui

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
import com.vitorota.albums.R
import kotlinx.android.synthetic.main.fragment_albums.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class AlbumsFragment : Fragment() {

    private val viewModel: AlbumsViewModel by viewModel()
    private val adapter: AlbumsAdapter by lazy {
        AlbumsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
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


        viewModel.albums.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}