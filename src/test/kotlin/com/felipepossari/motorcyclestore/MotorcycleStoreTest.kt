package com.felipepossari.motorcyclestore

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.felipepossari.motorcyclestore.adapter.`in`.web.api.controller.motorcycle.model.MotorcycleRequest
import com.felipepossari.motorcyclestore.adapter.out.web.api.LoginApiClient
import com.felipepossari.motorcyclestore.adapter.out.web.api.MotorcycleApiClient
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.security.authentication.UsernamePasswordCredentials
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import javax.inject.Inject

@MicronautTest
class MotorcycleStoreTest {

    companion object{
        private val ADMIN_USERNAME: String = "admin"
        private val OPERATOR_USERNAME: String = "user"
        private val PASSWORD: String = "123"
    }
    @Inject
    lateinit var application: EmbeddedApplication<*>

    @Inject
    @Client
    lateinit var motorcycleApiClient: MotorcycleApiClient

    @Inject
    @Client("/")
    lateinit var loginApiClient: LoginApiClient

    fun getLoginToken(username: String, password: String): String{
        val credentials = UsernamePasswordCredentials(username, password)
        val token = loginApiClient.login(credentials)
        return "${token.tokenType} ${token.accessToken}"
    }

    fun getAdminLoginToken(): String{
        return getLoginToken(ADMIN_USERNAME, PASSWORD)
    }

    fun getOperatorLoginToken(): String{
        return getLoginToken(OPERATOR_USERNAME, PASSWORD)
    }

    @Test
    fun `Get all should work fine for admin user`() {
        val token = getAdminLoginToken()
        val response = motorcycleApiClient.getAll(token)
        assertThat(response.status.code).isEqualTo(HttpStatus.OK.code)
    }

    @Test
    fun `Get all should work fine for operator user`() {
        val token = getOperatorLoginToken()
        val response = motorcycleApiClient.getAll(token)
        assertThat(response.status.code).isEqualTo(HttpStatus.OK.code)
    }

    @Test
    fun `Get by id should work fine for admin user`() {
        val token = getAdminLoginToken()
        val response = motorcycleApiClient.getById(token, 1L)
        assertThat(response.status.code).isEqualTo(HttpStatus.OK.code)
    }

    @Test
    fun `Get by id should work fine for operator user`() {
        val token = getOperatorLoginToken()
        val response = motorcycleApiClient.getById(token, 1L)
        assertThat(response.status.code).isEqualTo(HttpStatus.OK.code)
    }

    @Test
    fun `Post should work fine for admin user`() {
        val token = getAdminLoginToken()
        val request = MotorcycleRequest(1L, "Test", "Test", 250, 2010, 2010, 10000.0)
        val response = motorcycleApiClient.post(token, request)
        assertThat(response.status.code).isEqualTo(HttpStatus.CREATED.code)
    }

    @Test
    fun `Post should return forbidden for operator user`() {
        val token = getOperatorLoginToken()
        val request = MotorcycleRequest(1L, "Test", "Test", 250, 2010, 2010, 10000.0)

        assertThrows<HttpClientResponseException> {
            val response = motorcycleApiClient.post(token, request)
            assertThat(response.status.code).isEqualTo(HttpStatus.FORBIDDEN.code)
        }
    }

}
