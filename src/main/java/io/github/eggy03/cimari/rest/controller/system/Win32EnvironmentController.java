package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32Environment;
import io.github.eggy03.cimari.rest.exception.entity.ErrorResponse;
import io.github.eggy03.cimari.rest.service.system.Win32EnvironmentService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/system")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "System")
public class Win32EnvironmentController {

    private final Win32EnvironmentService service;

    @GET
    @Path("/env")
    @Operation(summary = "List of Win32_Environment objects")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "500", description = "Failure",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<Win32Environment> getAll() {
        return service.get(15);
    }
}
