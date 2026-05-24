package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Printer;
import io.github.eggy03.cimari.rest.exception.entity.ErrorResponse;
import io.github.eggy03.cimari.rest.service.peripheral.Win32PrinterService;
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

@Path("api/v1/peripheral")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Peripheral")
public class Win32PrinterController {

    private final Win32PrinterService service;

    @GET
    @Path("/printer")
    @Operation(summary = "List of Win32_Printer objects")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "500", description = "Failure",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<Win32Printer> getAll() {
        return service.get(15);
    }
}
