package com.xgiosebsx.mapper.data.network.dto

import com.google.gson.annotations.SerializedName

data class AlbumDTO(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("songs")
    val songDTOS: List<SongDTO>?
)