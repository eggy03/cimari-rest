/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetAdapter;
import io.github.eggy03.cimari.rest.mapping.network.MsftNetAdapterMapper;
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
 * This class executes the {@link StandardCimv2#MSFT_NET_ADAPTER} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link MsftNetAdapter} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * MsftNetAdapterService service = new MsftNetAdapterService();
 * List<MsftNetAdapter> adapters = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class MsftNetAdapterService implements CommonServiceInterface<MsftNetAdapter> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull MsftNetAdapterMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link MsftNetAdapter} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link MsftNetAdapter} objects representing the system's network adapters.
     * Returns a {@link Collections#emptyList()} if no adapters are detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<MsftNetAdapter> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(StandardCimv2.MSFT_NET_ADAPTER, timeout);
        return mapper.mapToList(terminalResult.result(), MsftNetAdapter.class);
    }
}
