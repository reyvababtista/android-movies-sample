package com.rey.list.data.repository

import com.google.common.truth.Truth.assertThat
import com.rey.lib.cleanarch.domain.dto.UNKNOWN_ERROR
import com.rey.lib.cleanarch.domain.dto.data
import com.rey.lib.cleanarch.domain.dto.error
import com.rey.list.domain.dto.MovieResponse
import com.rey.list.domain.usecase.repository.MovieRepository
import com.rey.movies.data.source.remote.FakeMovieRemoteDataImpl
import com.rey.movies.external.util.MovieUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

@ExperimentalCoroutinesApi
object MovieRepositoryImplTest : Spek({

    fun getObject(throwError: Boolean, movieList: List<MovieResponse>): MovieRepository {
        val fake = FakeMovieRemoteDataImpl(throwError, movieList)
        return MovieRepositoryImpl(fake)
    }

    Feature("movie repository") {
        Scenario("get movies return movie list") {
            lateinit var result: List<MovieResponse>
            lateinit var repository: MovieRepository

            Given("no error set, fake movie list generated") {
                repository = getObject(false, MovieUtil.generateFakeMoviesResponse(2))
            }
            When("get movie list") {
                runBlockingTest {
                    result = repository.getMovies().data
                }
            }
            Then("function return movie list") {
                assertThat(result.size).isEqualTo(2)
                assertThat(result[0].id).isEqualTo(0)
            }
        }

        Scenario("get movies return error") {
            lateinit var result: Exception
            lateinit var repository: MovieRepository

            Given("error is set, no fake movie list generated") {
                repository = getObject(true, emptyList())
            }
            When("get movie list") {
                runBlockingTest {
                    result = repository.getMovies().error
                }
            }
            Then("function return exception") {
                assertThat(result.message).isEqualTo(UNKNOWN_ERROR)
            }
        }
    }
})