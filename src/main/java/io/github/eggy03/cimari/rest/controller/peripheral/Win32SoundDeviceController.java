package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32SoundDevice;
import io.github.eggy03.cimari.rest.service.peripheral.Win32SoundDeviceService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/sound")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Peripheral")
public class Win32SoundDeviceController {

    private final Win32SoundDeviceService service;

    @GET
    @Operation(summary = "List of Win32_SoundDevice objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<Win32SoundDevice> getAll() {
        return service.get(15);
    }
}
