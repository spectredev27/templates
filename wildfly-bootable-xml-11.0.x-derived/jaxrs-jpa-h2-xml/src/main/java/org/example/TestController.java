package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/test")
public class TestController {

    @Inject
    private TemplateClassRepository templateClassRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<TemplateClass> result = templateClassRepository.selectAll();
        return Response.ok().entity(result).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(TemplateClass templateClass) {
        templateClassRepository.insert(templateClass);
        return Response.ok().build();
    }

}
