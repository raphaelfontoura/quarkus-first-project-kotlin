package com.github.raphaelfontoura

import jakarta.inject.Inject
import jakarta.validation.constraints.Positive
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
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
    fun getMessage(): Response? {
        return Response.ok(service.getAll()).build()
    }

    @POST
    fun saveMessage(message: Message): Response? {
        val newMessage = service.save(message)
        return Response.status(Response.Status.CREATED).entity(newMessage).build()
    }

    @GET
    @Path("/{id}")
    fun getOne(@RestPath @Positive id: Long): Response? {
        return Response.ok(service.getOneById(id)).build()
    }
}