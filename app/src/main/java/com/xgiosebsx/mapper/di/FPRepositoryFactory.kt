package com.xgiosebsx.mapper.di

import com.xgiosebsx.mapper.data.fp.repository.AlbumRepositoryImpl
import com.xgiosebsx.mapper.data.network.AlbumApiServiceImpl
import com.xgiosebsx.mapper.di.FPRMapperFactory.makeMapperFPR
import com.xgiosebsx.mapper.domain.repository.AlbumRepository

object FPRepositoryFactory {

    fun makeAlbumRepository(): AlbumRepository {
        return AlbumRepositoryImpl(
            AlbumApiServiceImpl(),
            makeMapperFPR()
        )
    }

}