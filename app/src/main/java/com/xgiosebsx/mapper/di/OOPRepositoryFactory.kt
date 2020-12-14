package com.xgiosebsx.mapper.di

import com.xgiosebsx.mapper.data.network.AlbumApiServiceImpl
import com.xgiosebsx.mapper.data.oop.mapper.AlbumDataMapper
import com.xgiosebsx.mapper.data.oop.mapper.SongDataMapper
import com.xgiosebsx.mapper.data.oop.mapper.util.NullableInputListMapperImpl
import com.xgiosebsx.mapper.data.oop.repository.AlbumRepositoryImpl
import com.xgiosebsx.mapper.di.OOPMapperFactory.makeMapperOOP
import com.xgiosebsx.mapper.domain.repository.AlbumRepository

object OOPRepositoryFactory {

    fun makeAlbumRepository(): AlbumRepository {
        return AlbumRepositoryImpl(
            AlbumApiServiceImpl(),
            makeMapperOOP()
        )
    }
}