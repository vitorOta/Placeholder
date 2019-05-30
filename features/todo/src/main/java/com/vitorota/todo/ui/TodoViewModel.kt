package com.vitorota.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorota.common.utils.SingleLiveEvent
import com.vitorota.todo.Todo
import com.vitorota.todo.usecase.ListUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * @author Vitor Ota
 * @since 30/05/2019
 */
class TodoViewModel(private val listUseCase: ListUseCase) : ViewModel() {
    private val _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>> = _todos

    var loadedOnce = false
        private set

    val showProgress = SingleLiveEvent<Void>()
    val hideProgress = SingleLiveEvent<Void>()

    fun initData() {
        viewModelScope.launch {
            showProgress.call()
            _todos.value = async{listUseCase.execute(null)}.await()
            loadedOnce = true
            hideProgress.call()
        }
    }

}