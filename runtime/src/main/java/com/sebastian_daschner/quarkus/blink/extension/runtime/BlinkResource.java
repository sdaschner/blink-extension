package com.sebastian_daschner.quarkus.blink.extension.runtime;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("blink")
public class BlinkResource {

    @GET
    public String blink() {
        return "blink";
    }

}
