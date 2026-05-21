/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Bios;
import io.github.eggy03.cimari.rest.mapping.mainboard.Win32BiosMapper;
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
 * This class executes the {@link Cimv2#WIN32_BIOS} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32Bios} objects.
 * </p>
 *
 * @since 0.0.1
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32BiosService implements CommonServiceInterface<Win32Bios> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32BiosMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32Bios} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32Bios} objects representing the system BIOS.
     * Returns a {@link Collections#emptyList()} if no BIOS entries are detected.
     * @since 0.0.1
     */
    @Override
    @CacheResult(cacheName = "Win32Bios")
    public @NonNull List<Win32Bios> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_BIOS, timeout);
        return mapper.mapToList(terminalResult.result(), Win32Bios.class);
    }
}