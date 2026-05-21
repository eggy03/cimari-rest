/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetIpAddress;
import io.github.eggy03.cimari.rest.mapping.network.MsftNetIpAddressMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.StandardCimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class executes the {@link StandardCimv2#MSFT_NET_IP_ADDRESS} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link MsftNetIpAddress} objects.
 * </p>
 *
 * @since 0.0.1
 */
@ApplicationScoped
@RequiredArgsConstructor
public class MsftNetIpAddressService implements CommonServiceInterface<MsftNetIpAddress> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull MsftNetIpAddressMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link MsftNetIpAddress} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link MsftNetIpAddress} objects representing the IPv4 and IPv6 configs.
     * Returns a {@link Collections#emptyList()} if no configs are detected.
     * @since 0.0.1
     */
    @Override
    public @NonNull List<MsftNetIpAddress> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(StandardCimv2.MSFT_NET_IP_ADDRESS, timeout);
        return mapper.mapToList(terminalResult.result(), MsftNetIpAddress.class);
    }
}
