package io.github.eggy03.cimari.rest.controller.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.rest.service.storage.Win32LogicalDiskService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/disk/logical")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Storage")
public class Win32LogicalDiskController {

    private final Win32LogicalDiskService service;

    @GET
    @Operation(summary = "List of Win32_LogicalDisk objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32LogicalDisk> getAll() {
        return service.get(15);
    }
}
