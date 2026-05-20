/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32PortConnector;
import io.github.eggy03.cimari.rest.mapping.mainboard.Win32PortConnectorMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import io.quarkus.cache.CacheResult;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class executes the {@link Cimv2#WIN32_PORT_CONNECTOR} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32PortConnector} objects.
 * </p>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32PortConnectorService implements CommonServiceInterface<Win32PortConnector> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32PortConnectorMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32PortConnector} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32PortConnector} objects representing the system's mainboard ports.
     * Returns a {@link Collections#emptyList()} if no ports are detected.
     * @since 0.1.0
     */
    @Override
    @CacheResult(cacheName = "Win32PortConnector")
    public @NonNull List<Win32PortConnector> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_PORT_CONNECTOR, timeout);
        return mapper.mapToList(terminalResult.result(), Win32PortConnector.class);
    }
}
