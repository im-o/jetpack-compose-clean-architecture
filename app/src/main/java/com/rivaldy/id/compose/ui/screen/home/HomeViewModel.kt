package com.rivaldy.id.compose.ui.screen.home

import androidx.annotation.WorkerThread
import androidx.lifecycle.ViewModel
import com.rivaldy.id.core.data.model.ProductResponse
import com.rivaldy.id.core.data.repository.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductRepositoryImpl
) : ViewModel() {

    @WorkerThread
    fun fetchProductsApiCall(): Flow<Result<ProductResponse>> {
        return repository.fetchProductsApiCall()
    }
}