/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.cimari.rest.exception.entity.ErrorResponse;
import io.github.eggy03.cimari.rest.service.network.MsftDnsClientServerAddressService;
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

@Path("api/v1/network")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Network")
public class MsftDnsClientServerAddressController {

    private final MsftDnsClientServerAddressService service;

    @GET
    @Path("/dns")
    @Operation(summary = "List of MSFT_DNSClientServerAddress objects")
    @APIResponse(responseCode = "200", description = "Success")
    @APIResponse(responseCode = "500", description = "Failure",
            content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ErrorResponse.class))
    )
    public List<MsftDnsClientServerAddress> getAll() {
        return service.get(15);
    }

}
