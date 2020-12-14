package com.xgiosebsx.mapper.data.network

import com.xgiosebsx.mapper.data.network.dto.AlbumDTO

interface AlbumApiService {

    fun getAlbumById(id: String): AlbumDTO

}