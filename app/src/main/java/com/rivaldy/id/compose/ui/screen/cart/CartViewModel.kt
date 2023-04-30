package com.rivaldy.id.compose.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rivaldy.id.core.data.UiState
import com.rivaldy.id.core.data.datasource.local.db.entity.ProductEntity
import com.rivaldy.id.core.data.repository.product.DbProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Created by github.com/im-o on 12/16/2022. */

@HiltViewModel
class CartViewModel @Inject constructor(
    private val dbRepository: DbProductRepositoryImpl
) : ViewModel() {

    private val _uiStateDbProducts: MutableStateFlow<UiState<MutableList<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val uiStateDbProducts: StateFlow<UiState<MutableList<ProductEntity>>> = _uiStateDbProducts

    fun getProductsDb(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
        viewModelScope.launch(dispatcher) {
            try {
                dbRepository.getProductsDb().catch {
                    _uiStateDbProducts.value = UiState.Error(it.message.toString())
                }.collect { product ->
                    _uiStateDbProducts.value = UiState.Success(product)
                }
            } catch (e: Exception) {
                _uiStateDbProducts.value = UiState.Error(e.message.toString())
            }
        }
    }

    fun deleteProductDb(product: ProductEntity) {
        viewModelScope.launch {
            val intDelete = dbRepository.deleteProductDb(product)
            if (intDelete == 1) getProductsDb()
        }
    }
}