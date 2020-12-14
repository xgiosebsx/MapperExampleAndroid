package com.xgiosebsx.mapper.data.network.dto

import com.google.gson.annotations.SerializedName

data class SongDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("link")
    val link: String?,
    @SerializedName("duration")
    val duration: Long?,
    @SerializedName("creationDate")
    val creationDate: String?,
    @SerializedName("uploadDate")
    val uploadDate: String?,
    @SerializedName("authorFullName")
    val authorFullName: String?
)