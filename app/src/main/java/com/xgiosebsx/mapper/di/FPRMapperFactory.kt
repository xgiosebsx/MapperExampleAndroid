package com.xgiosebsx.mapper.di

import com.xgiosebsx.mapper.data.fp.mapper.mapAlbumDto
import com.xgiosebsx.mapper.data.fp.mapper.mapNullInputList
import com.xgiosebsx.mapper.data.fp.mapper.mapSongDto
import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.domain.model.Album
import com.xgiosebsx.mapper.mapper.MapperFP

object FPRMapperFactory {

    private fun makeAlbumDataMapper(): (AlbumDTO) -> Album = { albumDto ->
        mapAlbumDto(albumDto) { listItemDto ->
            mapNullInputList(listItemDto) { songDto ->
                mapSongDto(songDto)
            }
        }
    }

    fun makeMapperFPR() = MapperFP(makeAlbumDataMapper())
}