package com.github.raphaelfontoura

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.inject.Inject
import jakarta.validation.constraints.Positive
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.RestPath

@Path("/message")
class MessageResource(
    @Inject
    private val service: MessageService
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getMessage(): Response.ResponseBuilder? {
        return Response.ok(service.getAll())
    }

    @POST
    fun saveMessage(message: Message) {
        service.save(message)
    }

    @GET
    @Path("/{id}")
    fun getOne(@RestPath @Positive id: Long): Response.ResponseBuilder? {
        return Response.ok(service.getOneById(id))
    }
}