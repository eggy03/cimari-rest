/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Baseboard;
import io.github.eggy03.cimari.rest.mapping.mainboard.Win32BaseboardMapper;
import io.github.eggy03.cimari.rest.service.CommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * This class executes the {@link Cimv2#WIN32_BASEBOARD} PowerShell command
 * and maps the resulting output into a {@link Win32Baseboard} with default configuration.
 * </p>
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32BaseboardService implements CommonServiceInterface<Win32Baseboard> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32BaseboardMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32Baseboard} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32Baseboard} objects representing the system motherboards.
     * Returns a {@link Collections#emptyList()} if no motherboard entries are detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<Win32Baseboard> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_BASEBOARD, timeout);
        return mapper.mapToList(terminalResult.result(), Win32Baseboard.class);
    }
}