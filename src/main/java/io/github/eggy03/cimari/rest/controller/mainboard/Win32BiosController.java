package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.service.mainboard.Win32BiosService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/bios")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32BiosController {

    private final Win32BiosService service;

    @GET
    public Response geWin32Bios() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
