package io.github.eggy03.cimari.rest.controller.processor;

import io.github.eggy03.cimari.rest.service.processor.Win32CacheMemoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/cache")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32CacheMemoryController {

    private final Win32CacheMemoryService service;

    @GET
    public Response getWin32CacheMemory() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
