package id.barakkastudio.sample.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.barakkastudio.core.data.UiState
import id.barakkastudio.core.data.datasource.local.db.entity.ProductEntity
import id.barakkastudio.core.domain.usecase.product.db.DeleteProductDbUseCase
import id.barakkastudio.core.domain.usecase.product.db.GetProductsDbUseCase
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
    private val getProductsDbUseCase: GetProductsDbUseCase,
    private val deleteProductDbUseCase: DeleteProductDbUseCase,
) : ViewModel() {

    private val _uiStateDbProducts: MutableStateFlow<UiState<MutableList<ProductEntity>>> = MutableStateFlow(UiState.Loading)
    val uiStateDbProducts: StateFlow<UiState<MutableList<ProductEntity>>> = _uiStateDbProducts

    fun getProductsDb(dispatcher: CoroutineDispatcher = Dispatchers.Default) {
        viewModelScope.launch(dispatcher) {
            try {
                getProductsDbUseCase.execute(Unit).catch {
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
            val intDelete = deleteProductDbUseCase.execute(product)
            if (intDelete == 1) getProductsDb()
        }
    }
}