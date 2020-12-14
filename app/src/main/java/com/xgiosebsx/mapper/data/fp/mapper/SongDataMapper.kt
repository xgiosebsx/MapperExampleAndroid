package com.xgiosebsx.mapper.data.fp.mapper

import com.xgiosebsx.mapper.data.network.dto.SongDTO
import com.xgiosebsx.mapper.domain.model.Song
import java.text.SimpleDateFormat
import java.util.*

fun mapSongDto(input: SongDTO): Song {
    return Song(
        input.id.orEmpty(),
        input.name.orEmpty(),
        input.link.orEmpty(),
        input.duration ?: 0,
        Song.Metadata(
            formatAlbumDate(input.creationDate),
            formatAlbumDate(input.uploadDate),
            input.authorFullName.orEmpty()
        )
    )
}

private fun formatAlbumDate(date: String?): Long {
    return date?.let {
        SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.UK).parse(it).time
    } ?: Long.MIN_VALUE
}