package com.rey.movies.data.repository.source.remote

import com.google.common.truth.Truth.assertThat
import com.rey.lib.cleanarch.domain.dto.data
import com.rey.movies.data.repository.source.remote.api.util.enqueueResponse
import com.rey.movies.data.source.remote.MovieRemoteDataImpl
import com.rey.movies.data.source.remote.api.MovieService
import com.rey.movies.domain.dto.MovieResponse
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRemoteDataTest : Spek({
    Feature("movie remote data") {
        val server by memoized { MockWebServer() }
        val service: MovieService by memoized {
            Retrofit.Builder()
                .baseUrl(server.url(""))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService::class.java)
        }
        val remoteData: MovieRemoteData by memoized { MovieRemoteDataImpl(service) }

        Scenario("get movies return movie list") {
            lateinit var result: List<MovieResponse>

            Given("mock movie response") {
                server.enqueueResponse(fileName = "movies.json")
            }
            When("get movies") {
                runBlocking {
                    result = remoteData.getMovies().data
                }
            }
            Then("function return movie list") {
                assertThat(result.size).isEqualTo(3)
                assertThat(result[0].id).isEqualTo("0")
            }
        }
    }
})