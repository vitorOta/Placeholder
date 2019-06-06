package com.vitorota.posts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vitorota.posts.ui.PostsViewModel
import com.vitorota.posts.usecase.ListUseCase
import com.vitorota.testcommon.TestCoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 *
 * @author Vitor Ota
 * @since 06/06/2019
 */
class PostsViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val testCoroutineRule = TestCoroutineRule()

    @MockK
    lateinit var listUseCase: ListUseCase

    lateinit var viewModel: PostsViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)

        viewModel = PostsViewModel(listUseCase)
    }

    @Test
    fun a() = testCoroutineRule.testCoroutineDispatcher.runBlockingTest{
        val response = emptyList<Post>()
        coEvery { listUseCase.execute(any()) } returns response

        viewModel.initData()

        assertEquals(response, viewModel.posts.value)
    }
}