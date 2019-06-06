package com.mmb.texttospeech.data.repository

import android.content.Context
import com.mmb.texttospeech.local.datasource.SpeechLocalDataSource
import com.mmb.texttospeech.remote.datasource.SpeechRemoteDataSource
import io.mockk.every
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class SpeechRepositoryTest {
    @Mock
    private lateinit var context: Context
    @Mock
    private lateinit var speechRemoteDataSource: SpeechRemoteDataSource

    @Mock
    private lateinit var speechLocalDataSource: SpeechLocalDataSource

    @Test
    fun `on bad request`() {
        val speechRepository = SpeechRepository(
            speechRemoteDataSource = speechRemoteDataSource
            , speechLocalDataSource = speechLocalDataSource
            , context = context
        )
    }
}