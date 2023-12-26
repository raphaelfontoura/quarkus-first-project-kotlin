package com.github.raphaelfontoura;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
class GreetingResource {

    @GET
    fun hello(): String {
        return "Hello RESTEasy";
    }
}

