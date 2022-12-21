package com.rivaldy.id.compose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.repository.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ProductRepositoryImpl
) : ViewModel() {

    private val _listProduct: MutableStateFlow<MutableList<Product?>?> = MutableStateFlow(mutableListOf())
    val listProduct = _listProduct.asStateFlow()

    fun fetchProductsApiCall() = viewModelScope.launch {
        repository.fetchProductsApiCall().collect { result ->
            result.onSuccess {
                _listProduct.emit(it.products)
            }
            result.onFailure {
                _listProduct.emit(mutableListOf())
            }
        }
    }
}