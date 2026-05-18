package io.github.eggy03.cimari.rest.controller.processor;

import io.github.eggy03.cimari.rest.service.processor.Win32ProcessorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/cpu")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32ProcessorController {

    private final Win32ProcessorService service;

    @GET
    public Response getWin32Processor() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
