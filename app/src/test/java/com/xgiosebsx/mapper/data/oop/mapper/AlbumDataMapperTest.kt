package com.xgiosebsx.mapper.data.oop.mapper

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.xgiosebsx.mapper.data.network.dto.AlbumDTO
import com.xgiosebsx.mapper.data.network.dto.SongDTO
import com.xgiosebsx.mapper.data.oop.mapper.util.NullableInputListMapper
import com.xgiosebsx.mapper.domain.model.Song
import org.junit.Test

class AlbumDataMapperTest {

    private val networkSongList = emptyList<SongDTO>()
    private val songList = emptyList<Song>()
    private val songListDataMapper: NullableInputListMapper<SongDTO, Song> = mock {
        whenever(it.map(networkSongList)).thenReturn(songList)
    }
    private val sut = AlbumDataMapper(songListDataMapper)

    private fun makeNetworkAlbum(
        id: String? = null,
        title: String? = null
    ): AlbumDTO {
        return AlbumDTO(id, title, networkSongList)
    }

    @Test
    fun `map should replace null values with defaults`() {
        val dto = makeNetworkAlbum()

        val actual = sut.map(dto)

        assertThat(actual.id).isEmpty()
        assertThat(actual.title).isEmpty()
    }

    @Test
    fun `map should assign correct values`() {
        val dto = makeNetworkAlbum("id", "title")

        val actual = sut.map(dto)

        assertThat(actual.id).isEqualTo("id")
        assertThat(actual.title).isEqualTo("title")
        assertThat(actual.songs).isEqualTo(songList)
    }
}