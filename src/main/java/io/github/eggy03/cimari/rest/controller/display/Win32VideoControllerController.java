package io.github.eggy03.cimari.rest.controller.display;

import io.github.eggy03.cimari.rest.service.display.Win32VideoControllerService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/display")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32VideoControllerController {

    private final Win32VideoControllerService service;

    @GET
    @Path("/videocontroller")
    public Response geWin32VideoController() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
