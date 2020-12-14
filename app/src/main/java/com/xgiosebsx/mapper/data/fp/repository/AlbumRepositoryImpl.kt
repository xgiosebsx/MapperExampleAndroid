package com.xgiosebsx.mapper.data.fp.repository

import com.xgiosebsx.mapper.data.network.AlbumApiService
import com.xgiosebsx.mapper.domain.model.Album
import com.xgiosebsx.mapper.domain.repository.AlbumRepository
import com.xgiosebsx.mapper.mapper.MapperFP

class AlbumRepositoryImpl(
    private val albumApiService: AlbumApiService,
    private val mapperFP: MapperFP
) : AlbumRepository {

    override fun getAlbumById(id: String): Album {
        val dto = albumApiService.getAlbumById(id)
        return mapperFP.mapAlbumDto(dto)
    }
}