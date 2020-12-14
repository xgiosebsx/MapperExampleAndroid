package com.xgiosebsx.mapper.di

import com.xgiosebsx.mapper.data.oop.mapper.AlbumDataMapper
import com.xgiosebsx.mapper.data.oop.mapper.SongDataMapper
import com.xgiosebsx.mapper.data.oop.mapper.util.NullableInputListMapperImpl
import com.xgiosebsx.mapper.mapper.MapperOOP

object OOPMapperFactory {

    fun makeMapperOOP(): MapperOOP {
        return MapperOOP(
            AlbumDataMapper(NullableInputListMapperImpl(SongDataMapper()))
        )
    }
}