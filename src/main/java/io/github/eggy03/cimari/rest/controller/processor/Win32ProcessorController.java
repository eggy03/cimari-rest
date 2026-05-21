package io.github.eggy03.cimari.rest.controller.processor;

import io.github.eggy03.cimari.rest.entity.processor.Win32Processor;
import io.github.eggy03.cimari.rest.service.processor.Win32ProcessorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/cpu")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Processor")
public class Win32ProcessorController {

    private final Win32ProcessorService service;

    @GET
    @Operation(summary = "List of Win32_Processor objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32Processor> getAll() {
        return service.get(15);
    }
}
