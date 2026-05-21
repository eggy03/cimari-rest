/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetIpAddress;
import io.github.eggy03.cimari.rest.service.network.MsftNetIpAddressService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("api/v1/network/ip")
@Produces(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
@Tag(name = "Network")
public class MsftNetIpAddressController {

    private final MsftNetIpAddressService service;

    @GET
    @Operation(summary = "List of MSFT_NetIPAddress objects")
    @APIResponse(responseCode = "200", description = "Success")
    public List<MsftNetIpAddress> getAll() {
        return service.get(15);
    }

}
