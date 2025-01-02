package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collections;
import java.util.Map;

@Path("/test")
public class TestController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Map<String, String> responseBody = Collections.singletonMap("result", "Success");
        return Response.ok().entity(responseBody).build();
    }

}
