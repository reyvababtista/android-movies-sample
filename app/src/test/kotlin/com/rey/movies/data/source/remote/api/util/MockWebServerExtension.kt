package com.rey.movies.data.source.remote.api.util

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source

fun MockWebServer.enqueueResponse(
    fileName: String,
    headers: Map<String, String> = emptyMap(),
    responseCode: Int = 200
) {
    val inputStream =
        javaClass.classLoader?.getResourceAsStream("com/rey/movies/data/source/remote/api/response/$fileName")
    val source = inputStream?.source()?.buffer()
    val mockResponse = MockResponse()

    for ((key, value) in headers) {
        mockResponse.addHeader(key, value)
    }

    this.enqueue(
        mockResponse.setResponseCode(responseCode).setBody(source!!.readString(Charsets.UTF_8))
    )
}