package io.github.eggy03.cimari.rest.controller.display;

import io.github.eggy03.cimari.rest.entity.display.Win32VideoController;
import io.github.eggy03.cimari.rest.service.display.Win32VideoControllerService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/display")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Display")
public class Win32VideoControllerController {

    private final Win32VideoControllerService service;

    @GET
    @Path("/videocontroller")
    @Operation(summary = "List of Win32_VideoController objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32VideoController> getAll() {
        return service.get(15);
    }
}
