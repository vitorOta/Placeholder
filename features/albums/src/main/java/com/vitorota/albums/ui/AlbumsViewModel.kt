package com.vitorota.albums.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorota.albums.Album
import com.vitorota.albums.usecase.ListUseCase
import com.vitorota.common.utils.SingleLiveEvent
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 *
 * @author Vitor Ota
 * @since 30/05/2019
 */
class AlbumsViewModel(
    private val listUseCase: ListUseCase
) : ViewModel() {
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>> = _albums

    var loadedOnce = false
        private set

    val showProgress = SingleLiveEvent<Void>()
    val hideProgress = SingleLiveEvent<Void>()

    fun initData() {
        viewModelScope.launch {
            showProgress.call()
            _albums.value = async { listUseCase.execute(null) }.await()
            loadedOnce = true
            hideProgress.call()
        }
    }
}