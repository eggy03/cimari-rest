/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.memory;

import io.github.eggy03.cimari.rest.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.cimari.rest.mapping.memoery.Win32PhysicalMemoryMapper;
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
 * This class executes the {@link Cimv2#WIN32_PHYSICAL_MEMORY} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32PhysicalMemory} objects.
 * </p>
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32PhysicalMemoryService implements CommonServiceInterface<Win32PhysicalMemory> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32PhysicalMemoryMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32PhysicalMemory} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32PhysicalMemory} objects representing the system's RAM.
     * Returns a {@link Collections#emptyList()} if no memory modules are detected.
     * @since 0.0.1
     */
    @Override
    @CacheResult(cacheName = "Win32PhysicalMemory")
    public @NonNull List<Win32PhysicalMemory> get(long timeout) {
        final TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_PHYSICAL_MEMORY, timeout);
        return mapper.mapToList(terminalResult.result(), Win32PhysicalMemory.class);
    }

}