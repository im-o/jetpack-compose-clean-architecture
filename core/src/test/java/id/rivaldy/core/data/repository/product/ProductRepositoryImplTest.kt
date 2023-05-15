package id.rivaldy.core.data.repository.product

import id.rivaldy.core.data.datasource.remote.ApiService
import id.rivaldy.core.util.UtilTests
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.given
import org.mockito.kotlin.whenever

/** Created by github.com/im-o on 5/3/2023.  */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ProductRepositoryImplTest {

    @Mock
    private lateinit var apiService: ApiService
    private lateinit var productRepositoryImpl: ProductRepositoryImpl

    @Before
    fun setUp() {
        productRepositoryImpl = ProductRepositoryImpl(apiService)
    }

    @Test
    fun `getProductsApiCall should return the correct data`() = runTest {
        // Given
        val expectedResponse = UtilTests.dummyProductResponse
        whenever(apiService.getProducts()).thenReturn(expectedResponse)

        // When
        val actualResponse = productRepositoryImpl.getProductsApiCall().first()

        // Then
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun `getProductsApiCall should return error flow when an exception occurs`() = runTest {
        // Given
        val expectedException = RuntimeException("An error occurred")
        given(apiService.getProducts()).willThrow(expectedException)

        // When
        val actualException = runCatching { productRepositoryImpl.getProductsApiCall().first() }

        // Then
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }

    @Test
    fun `getProductByIdApiCall should return the correct data`() = runTest {
        // Given
        val expectedResponse = UtilTests.dummyProduct
        val productId = 1
        whenever(apiService.getProductById(productId)).thenReturn(expectedResponse)

        // When
        val actualResponse = productRepositoryImpl.getProductByIdApiCall(productId).first()

        // Then
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun `getProductByIdApiCall should return error flow when an exception occurs`() = runTest {
        // Given
        val expectedException = RuntimeException("An error occurred")
        val productId = 1
        given(apiService.getProductById(productId)).willThrow(expectedException)

        // When
        val actualException = runCatching {
            productRepositoryImpl.getProductByIdApiCall(productId).first()
        }

        // Then
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }

    @Test
    fun `searchProductApiCall should return the correct data`() = runTest {
        // Given
        val expectedResponse = UtilTests.dummyProductResponse
        val query = "test"
        whenever(apiService.searchProduct(query)).thenReturn(expectedResponse)

        // When
        val actualResponse = productRepositoryImpl.searchProductApiCall(query).first()

        // Then
        assertEquals(expectedResponse, actualResponse)
    }

    @Test
    fun `searchProductApiCall should return error flow when an exception occurs`() = runTest {
        // Given
        val expectedException = RuntimeException("An error occurred")
        val query = "test"
        given(apiService.searchProduct(query)).willThrow(expectedException)

        // When
        val actualException = runCatching {
            productRepositoryImpl.searchProductApiCall(query).first()
        }

        // Then
        assertTrue(actualException.isFailure)
        assertEquals(expectedException, actualException.exceptionOrNull())
    }
}