package com.xgiosebsx.mapper.data.oop.repository

import com.xgiosebsx.mapper.data.network.AlbumApiService
import com.xgiosebsx.mapper.domain.model.Album
import com.xgiosebsx.mapper.domain.repository.AlbumRepository
import com.xgiosebsx.mapper.mapper.MapperOOP

class AlbumRepositoryImpl(
    private val albumApiService: AlbumApiService,
    private val mapperOOP: MapperOOP
) : AlbumRepository {

    override fun getAlbumById(id: String): Album {
        val dto = albumApiService.getAlbumById(id)
        return mapperOOP.mapAlbumDto.map(dto)
    }

}