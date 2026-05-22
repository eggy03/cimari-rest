package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Battery;
import io.github.eggy03.cimari.rest.service.peripheral.Win32BatteryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/peripheral")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Peripheral")
public class Win32BatteryController {

    private final Win32BatteryService service;

    @GET
    @Path("/battery")
    @Operation(summary = "List of Win32_Battery objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32Battery> getAll() {
        return service.get(15);
    }
}
