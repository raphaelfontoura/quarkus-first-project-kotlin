package com.github.raphaelfontoura

import jakarta.persistence.EntityNotFoundException
import jakarta.ws.rs.core.Response
import jakarta.ws.rs.ext.ExceptionMapper
import jakarta.ws.rs.ext.Provider
import org.jboss.resteasy.reactive.RestResponse


@Provider
class EntityNotFoundExceptionMapper: ExceptionMapper<EntityNotFoundException> {

    override fun toResponse(e: EntityNotFoundException?): Response? {
        val error = ErrorResponse(status = 404, title = "Entity Not Found", message = e?.message)
        return Response.status(RestResponse.Status.NOT_FOUND).entity(error).build()
    }
}

data class ErrorResponse(
    val status: Int,
    val title: String,
    val message: String?
)