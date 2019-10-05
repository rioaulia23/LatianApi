package com.example.latihanapi.models

import com.google.gson.annotations.SerializedName

data class ModelBranch(
    @SerializedName("id_branch") var id_branch: Int,
    @SerializedName("branchName") var branchName: String
)

