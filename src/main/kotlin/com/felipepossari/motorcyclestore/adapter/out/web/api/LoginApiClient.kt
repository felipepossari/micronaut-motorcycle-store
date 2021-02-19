package com.felipepossari.motorcyclestore.adapter.out.web.api

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.security.token.jwt.render.BearerAccessRefreshToken

@Client("/")
interface LoginApiClient {

    @Post("/login")
    fun login(@Body login: UsernamePasswordCredentials): BearerAccessRefreshToken
}