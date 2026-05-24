package io.github.eggy03.cimari.rest.controller.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32DiskPartition;
import io.github.eggy03.cimari.rest.exception.entity.ErrorResponse;
import io.github.eggy03.cimari.rest.service.storage.Win32DiskPartitionService;
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

@Path("api/v1/disk")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Storage")
public class Win32DiskPartitionController {

    private final Win32DiskPartitionService service;

    @GET
    @Path("/partition")
    @Operation(summary = "List of Win32_DiskPartition objects")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "500", description = "Failure",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<Win32DiskPartition> getAll() {
        return service.get(15);
    }
}
