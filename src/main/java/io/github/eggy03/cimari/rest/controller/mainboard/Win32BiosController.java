package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Bios;
import io.github.eggy03.cimari.rest.service.mainboard.Win32BiosService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/bios")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Mainboard")
public class Win32BiosController {

    private final Win32BiosService service;

    @GET
    @Operation(summary = "List of Win32_BIOS objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32Bios> getAll() {
        return service.get(15);
    }
}
