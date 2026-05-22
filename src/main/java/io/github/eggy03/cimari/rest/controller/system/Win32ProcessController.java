package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32Process;
import io.github.eggy03.cimari.rest.service.system.Win32ProcessService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/system")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "System")
public class Win32ProcessController {

    private final Win32ProcessService service;

    @GET
    @Path("/process")
    @Operation(summary = "List of Win32_Process objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32Process> getAll() {
        return service.get(15);
    }
}
