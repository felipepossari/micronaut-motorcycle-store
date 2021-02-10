package com.felipepossari.motorcyclestore.infrastructure.security

import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationException
import io.micronaut.security.authentication.AuthenticationProvider
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.UserDetails
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword : AuthenticationProvider {

    companion object {
        val log = LoggerFactory.getLogger(this::class.qualifiedName)
    }

    override fun authenticate(httpRequest: HttpRequest<*>?, authenticationRequest: AuthenticationRequest<*, *>?)
            : Publisher<AuthenticationResponse> {
        log.info("Authentication required. User: ${authenticationRequest?.identity} " +
                "- Pass: ${authenticationRequest?.secret}")
        return Flowable.create({emmiter : FlowableEmitter<AuthenticationResponse> ->
            if (authenticationRequest?.identity == "admin" && authenticationRequest?.secret == "123") {
                emmiter.onNext(UserDetails("user",
                        mutableListOf("admin", "operator"),
                        mutableMapOf<String, Any>("email" to "user@motorcycle.com", "phone" to "553512345-1234")))
                emmiter.onComplete()
            } else if (authenticationRequest?.identity == "user" && authenticationRequest?.secret == "123") {
                emmiter.onNext(UserDetails("user",
                        mutableListOf("operator"),
                        mutableMapOf<String, Any>("email" to "user@motorcycle.com", "phone" to "553512345-1234")))
                emmiter.onComplete()
            }
            else{
                emmiter.onError(AuthenticationException("Wrong username or password"))
            }
        }, BackpressureStrategy.ERROR)
    }
}