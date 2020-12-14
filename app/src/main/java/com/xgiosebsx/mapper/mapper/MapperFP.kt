package com.xgiosebsx.mapper.mapper

import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.domain.model.Album

class MapperFP(val mapAlbumDto: (AlbumDTO) -> Album)
