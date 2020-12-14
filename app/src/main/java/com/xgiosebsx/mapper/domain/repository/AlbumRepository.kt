package com.xgiosebsx.mapper.domain.repository

import com.xgiosebsx.mapper.domain.model.Album

interface AlbumRepository {

    fun getAlbumById(id: String): Album

}