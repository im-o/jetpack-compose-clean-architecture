package com.rivaldy.id.compose.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.model.Product
import com.rivaldy.id.core.data.model.mapper.ProductMapper.mapFromProductToEntity
import com.rivaldy.id.core.data.repository.DbProductRepositoryImpl
import com.rivaldy.id.core.data.repository.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ProductRepositoryImpl,
    private val dbRepository: DbProductRepositoryImpl
) : ViewModel() {

    private val _uiStateProduct: MutableStateFlow<UiState<Product>> = MutableStateFlow(UiState.Loading)
    val uiStateProduct: StateFlow<UiState<Product>>
        get() = _uiStateProduct

    private val _uiStateDbProduct: MutableStateFlow<UiState<Product>> = MutableStateFlow(UiState.Loading)
    val uiStateDbProduct: StateFlow<UiState<Product>>
        get() = _uiStateDbProduct

    fun getProductByIdApiCall(id: Int) {
        viewModelScope.launch {
            try {
                repository.getProductByIdApiCall(id)
                    .catch {
                        _uiStateProduct.value = UiState.Error(it.message.toString())
                    }
                    .collect { product ->
                        _uiStateProduct.value = UiState.Success(product)
                    }
            } catch (e: Exception) {
                _uiStateProduct.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun insertProductDb(product: Product) {
        viewModelScope.launch {
            dbRepository.insertProductDb(mapFromProductToEntity(product))
        }
    }
}