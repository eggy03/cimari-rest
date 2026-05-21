/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.system;


import io.github.eggy03.cimari.rest.entity.system.Win32Environment;
import io.github.eggy03.cimari.rest.mapping.system.Win32EnvironmentMapper;
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
 * This class executes the {@link Cimv2#WIN32_ENVIRONMENT} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32Environment} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * Win32EnvironmentService service = new Win32EnvironmentService();
 * List<Win32Environment> env = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32EnvironmentService implements CommonServiceInterface<Win32Environment> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32EnvironmentMapper mapper;


    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32Environment} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32Environment} objects representing the env variables.
     * Returns a {@link Collections#emptyList()} if no env variables are detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<Win32Environment> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_ENVIRONMENT, timeout);
        return mapper.mapToList(terminalResult.result(), Win32Environment.class);
    }
}
