package com.example.androidtestsidp

import com.example.androidtestsidp.di.appModule
import com.example.androidtestsidp.model.Item
import com.example.androidtestsidp.network.Repository
import com.example.androidtestsidp.presentation.MainViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.declareMock
import kotlinx.coroutines.test.runTest
import org.koin.test.mock.MockProvider
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MainViewModelTest : KoinTest {

    private val repository: Repository by inject()
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(appModule)
    }

    @Before
    fun setup() {
        declareMock<Repository>()
        viewModel = MainViewModel(repository)
    }

    @Test
    fun fetchCount() = runTest {
        // Mock repository response
        val mockItems = List(10) { index -> Item(id = "index: ".plus(index), name = "Item $index") }
        whenever(repository.getItems()).thenReturn(mockItems)

        // Call the method and check the result
        viewModel.fetchAndCountItems()
        assertEquals(10, viewModel.itemCount.value)
    }
}