package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/test")
public class TestController {

    private static final String JSON = MediaType.APPLICATION_JSON;

    @Inject
    private TemplateClassRepository templateClassRepository;

    @GET
    @Produces(JSON)
    public Response get() {
        List<TemplateClass> result = templateClassRepository.selectAll();
        return Response.ok().entity(result).build();
    }

    @POST
    @Consumes(JSON)
    public Response post(TemplateClass templateClass) {
        templateClassRepository.insert(templateClass);
        return Response.ok().build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(JSON)
    public Response put(@PathParam("id") int id, TemplateClass templateClass) {
        templateClass.setId(id);
        templateClassRepository.update(templateClass);
        return Response.ok().build();
    }

    @Path("/{id}")
    @DELETE
    public Response delete(@PathParam("id") int id) {
        templateClassRepository.delete(id);
        return Response.ok().build();
    }

}
