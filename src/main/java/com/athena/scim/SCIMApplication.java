package com.athena.scim;

import org.glassfish.jersey.server.ResourceConfig;

public class SCIMApplication extends ResourceConfig {
    public SCIMApplication(){
        packages("com.athena.scim.core");
    }
}
