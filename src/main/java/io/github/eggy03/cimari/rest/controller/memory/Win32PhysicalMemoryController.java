package io.github.eggy03.cimari.rest.controller.memory;

import io.github.eggy03.cimari.rest.service.memory.Win32PhysicalMemoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/memory")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32PhysicalMemoryController {

    private final Win32PhysicalMemoryService service;

    @GET
    public Response getWin32PhysicalMemory() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
