package com.xgiosebsx.mapper.data.fp.mapper

import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.data.network.dto.SongDTO
import com.xgiosebsx.mapper.domain.model.Album
import com.xgiosebsx.mapper.domain.model.Song

inline fun mapAlbumDto(input: AlbumDTO, mapSongList: (List<SongDTO>?) -> List<Song>): Album {
    return Album(
        input.id.orEmpty(),
        input.title.orEmpty(),
        mapSongList(input.songDTOS)
    )
}