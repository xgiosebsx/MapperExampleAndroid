package com.xgiosebsx.mapper.data.network

import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.data.network.dto.SongDTO

class AlbumApiServiceImpl : AlbumApiService {
    override fun getAlbumById(id: String): AlbumDTO = AlbumDTO(
        "1", "Title", listOf(
            SongDTO("1", "Name", "Link", 0, "", "", "")
        )
    )
}