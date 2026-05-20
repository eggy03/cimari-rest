package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.service.mainboard.Win32BaseboardService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/baseboard")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32BaseboardController {

    private final Win32BaseboardService service;

    @GET
    public Response geWin32Baseboard() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
