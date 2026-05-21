package io.github.eggy03.cimari.rest.controller.memory;

import io.github.eggy03.cimari.rest.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.cimari.rest.service.memory.Win32PhysicalMemoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/memory")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Memory")
public class Win32PhysicalMemoryController {

    private final Win32PhysicalMemoryService service;

    @GET
    @Operation(summary = "List of Win32_PhysicalMemory objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32PhysicalMemory> getAll() {
        return service.get(15);
    }
}
