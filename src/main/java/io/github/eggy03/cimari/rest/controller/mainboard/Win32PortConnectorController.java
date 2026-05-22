package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32PortConnector;
import io.github.eggy03.cimari.rest.service.mainboard.Win32PortConnectorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/mainboard")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Mainboard")
public class Win32PortConnectorController {

    private final Win32PortConnectorService service;

    @GET
    @Path("/port")
    @Operation(summary = "List of Win32_PortConnector objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32PortConnector> getAll() {
        return service.get(15);
    }
}
