package com.vitorota.todo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.vitorota.todo.R
import kotlinx.android.synthetic.main.fragment_todo.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class TodoFragment : Fragment() {

    private val adapter: TodoAdapter by lazy {
        TodoAdapter()
    }
    private val viewModel: TodoViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        setupObservables()

        if (!viewModel.loadedOnce) {
            viewModel.initData()
        }
    }

    private fun setupView() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        recyclerView.adapter = adapter
    }

    private fun setupObservables() {
        viewModel.showProgress.observe(this, Observer {
            recyclerView.isVisible = false
            progressBar.isVisible = true
        })

        viewModel.hideProgress.observe(this, Observer {
            recyclerView.isVisible = true
            progressBar.isVisible = false
        })


        viewModel.todos.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}