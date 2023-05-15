package id.rivaldy.core.data.model


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("products")
    val products: MutableList<Product>? = null,
    @SerializedName("skip")
    val skip: Int? = null,
    @SerializedName("total")
    val total: Int? = null
)