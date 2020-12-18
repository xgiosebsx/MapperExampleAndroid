package com.xgiosebsx.mapper.data.fp.mapper

import com.google.common.truth.Truth.assertThat
import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.data.network.dto.SongDTO
import com.xgiosebsx.mapper.domain.model.Song
import org.junit.Test

class AlbumDataMapperKtTest {

    private val networkSongList = emptyList<SongDTO>()
    private val songList = emptyList<Song>()
    private val mapSongList: (List<SongDTO>?) -> List<Song> = {
        if (it === networkSongList) songList else throw Exception("not mocked")
    }

    private fun makeNetworkAlbum(
        id: String? = null,
        title: String? = null
    ): AlbumDTO {
        return AlbumDTO(id, title, networkSongList)
    }

    @Test
    fun `mapAlbumDto should replace null values with defaults`() {
        val dto = makeNetworkAlbum()

        val actual = mapAlbumDto(dto, mapSongList)

        assertThat(actual.id).isEmpty()
        assertThat(actual.title).isEmpty()
    }

    @Test
    fun `mapAlbumDto should assign correct values`() {
        val dto = makeNetworkAlbum("id", "title")

        val actual = mapAlbumDto(dto, mapSongList)

        assertThat(actual.id).isEqualTo("id")
        assertThat(actual.title).isEqualTo("title")
        assertThat(actual.songs).isEqualTo(songList)
    }
}