package com.example.latihanapi.models

import com.google.gson.annotations.SerializedName

data class ModelProduct(
    @SerializedName("id_product") var id_product: Int,
    @SerializedName("productName") var productName: String,
    @SerializedName("image") var image: String,
    @SerializedName("id_branch") var id_branch: Int,
    @SerializedName("branch") var branch: ModelBranch
)
