package com.athena.scim.core;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/v1")
public class ScimResource {
    @GET
    @Path("/ResourceTypes")
    @Produces("application/json")
    public String ResourceTypes(){
        return ResourceTypeValue.getValue();
    }
}
