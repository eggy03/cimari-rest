/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32DiskPartition;
import io.github.eggy03.cimari.rest.mapping.storage.Win32DiskPartitionMapper;
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
 * This class executes the {@link Cimv2#WIN32_DISK_PARTITION} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32DiskPartition} objects.
 * </p>
 *
 * @since 0.0.1
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32DiskPartitionService implements CommonServiceInterface<Win32DiskPartition> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32DiskPartitionMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32DiskPartition} objects <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32DiskPartition} objects representing the disk partitions.
     * Returns a {@link Collections#emptyList()} if no partitions are detected.
     * @since 0.0.1
     */
    @Override
    public @NonNull List<Win32DiskPartition> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_DISK_PARTITION, timeout);
        return mapper.mapToList(terminalResult.result(), Win32DiskPartition.class);
    }

}