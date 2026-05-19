package io.github.eggy03.cimari.rest.controller.display;

import io.github.eggy03.cimari.rest.service.display.Win32DesktopMonitorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("api/v1/display")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class Win32DesktopMonitorController {

    private final Win32DesktopMonitorService service;

    @GET
    @Path("/monitor")
    public Response getWin32DesktopMonitor() {
        return Response
                .ok(service.get(15))
                .build();
    }
}
