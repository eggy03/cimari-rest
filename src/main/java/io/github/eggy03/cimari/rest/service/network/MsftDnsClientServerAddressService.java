/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.network;

import io.github.eggy03.cimari.rest.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.cimari.rest.mapping.network.MsftDnsClientServerAddressMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.StandardCimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class executes the {@link StandardCimv2#MSFT_NET_DNS_CLIENT_SERVER_ADDRESS} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link MsftDnsClientServerAddress} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * MsftDnsClientServerAddressService service = new MsftDnsClientServerAddressService();
 * List<MsftDnsClientServerAddress> dns = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class MsftDnsClientServerAddressService implements CommonServiceInterface<MsftDnsClientServerAddress> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull MsftDnsClientServerAddressMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link MsftDnsClientServerAddress} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link MsftDnsClientServerAddress} objects representing the DNS configs.
     * Returns a {@link Collections#emptyList()} if no configs are detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<MsftDnsClientServerAddress> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(StandardCimv2.MSFT_NET_DNS_CLIENT_SERVER_ADDRESS, timeout);
        return mapper.mapToList(terminalResult.result(), MsftDnsClientServerAddress.class);
    }
}
