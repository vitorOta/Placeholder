package com.vitorota.posts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorota.common.utils.SingleLiveEvent
import com.vitorota.posts.Post
import com.vitorota.posts.usecase.ListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class PostsViewModel(private val listUseCase: ListUseCase) : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    var loadedOnce = false
        private set

    val showProgress = SingleLiveEvent<Void>()
    val hideProgress = SingleLiveEvent<Void>()

    fun initData() {
        viewModelScope.launch {
            showProgress.call()
            _posts.value = async { listUseCase.execute(null) }.await()
            loadedOnce = true
            hideProgress.call()
        }
    }
}