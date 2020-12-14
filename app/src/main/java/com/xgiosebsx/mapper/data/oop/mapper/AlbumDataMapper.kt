package com.xgiosebsx.mapper.data.oop.mapper

import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.data.network.dto.SongDTO
import com.xgiosebsx.mapper.data.oop.mapper.util.Mapper
import com.xgiosebsx.mapper.data.oop.mapper.util.NullableInputListMapper
import com.xgiosebsx.mapper.domain.model.Album
import com.xgiosebsx.mapper.domain.model.Song

class AlbumDataMapper(
    private val songDTOListDataMapper: NullableInputListMapper<SongDTO, Song>
) : Mapper<AlbumDTO, Album> {

    override fun map(input: AlbumDTO): Album {
        return Album(
            input.id.orEmpty(),
            input.title.orEmpty(),
            songDTOListDataMapper.map(input.songDTOS)
        )
    }

}