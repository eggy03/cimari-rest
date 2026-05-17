package io.github.eggy03.controller;

import io.github.eggy03.cimari.service.compounded.Win32ProcessorToCacheMemoryService;
import io.github.eggy03.cimari.service.processor.Win32CacheMemoryService;
import io.github.eggy03.cimari.service.processor.Win32ProcessorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("api/v1/cpu")
@Produces(MediaType.APPLICATION_JSON)
public class ProcessorController {

    @GET
    public Response getWin32Processor() {
        return Response
                .ok(new Win32ProcessorService().get(15))
                .build();
    }

    @GET
    @Path("/cache")
    public Response getWin32CacheMemory() {
        return Response
                .ok(new Win32CacheMemoryService().get(15))
                .build();
    }

    @GET
    @Path("/full")
    public Response getWin32ProcessorAndCacheMemory() {
        return Response
                .ok(new Win32ProcessorToCacheMemoryService().get(15))
                .build();
    }
}
