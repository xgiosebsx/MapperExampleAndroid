package com.xgiosebsx.mapper.data.fp.mapper

import com.google.common.truth.Truth.assertThat
import com.xgiosebsx.mapper.data.network.dto.SongDTO
import org.junit.Test

class SongDataMapperKtTest {

    private fun makeNetworkSong(
        id: String? = null,
        name: String? = null,
        link: String? = null,
        duration: Long? = null,
        creationDate: String? = null,
        uploadDate: String? = null,
        authorFullName: String? = null
    ): SongDTO {
        return SongDTO(
            id,
            name,
            link,
            duration,
            creationDate,
            uploadDate,
            authorFullName
        )
    }

    @Test
    fun `mapSongDto should replace null values with defaults`() {
        val dto = makeNetworkSong()

        val actual = mapSongDto(dto)

        assertThat(actual.id).isEmpty()
        assertThat(actual.name).isEmpty()
        assertThat(actual.link).isEmpty()
        assertThat(actual.duration).isEqualTo(0)
        assertThat(actual.metadata.authorFullName).isEmpty()
        assertThat(actual.metadata.creationDate).isEqualTo(Long.MIN_VALUE)
        assertThat(actual.metadata.uploadDate).isEqualTo(Long.MIN_VALUE)
    }

    @Test
    fun `mapSongDto should replace assign and format correct values`() {
        val dto = makeNetworkSong(
            "id",
            "name",
            "link",
            50L,
            "29 May 2015 05:50:06",
            "29 May 2015 05:50:06",
            "Name Surname"
        )

        val actual = mapSongDto(dto)

        assertThat(actual.id).isEqualTo("id")
        assertThat(actual.name).isEqualTo("name")
        assertThat(actual.link).isEqualTo("link")
        assertThat(actual.duration).isEqualTo(50)
        assertThat(actual.metadata.authorFullName).isEqualTo("Name Surname")
        assertThat(actual.metadata.creationDate).isEqualTo(1432896606000)
        assertThat(actual.metadata.uploadDate).isEqualTo(1432875006000)
    }

}