/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.rest.mapping.storage.Win32LogicalDiskMapper;
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
 * This class executes the {@link Cimv2#WIN32_LOGICAL_DISK} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32LogicalDisk} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * Win32LogicalDiskService service = new Win32LogicalDiskService();
 * List<Win32LogicalDisk> logicalDisks = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32LogicalDiskService implements CommonServiceInterface<Win32LogicalDisk> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32LogicalDiskMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32LogicalDisk} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32LogicalDisk} objects representing the logical volumes.
     * Returns a {@link Collections#emptyList()} if no volumes are detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<Win32LogicalDisk> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_LOGICAL_DISK, timeout);
        return mapper.mapToList(terminalResult.result(), Win32LogicalDisk.class);
    }
}
