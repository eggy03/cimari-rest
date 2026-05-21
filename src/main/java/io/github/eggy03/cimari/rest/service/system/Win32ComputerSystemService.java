/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.system;

import io.github.eggy03.cimari.rest.entity.system.Win32ComputerSystem;
import io.github.eggy03.cimari.rest.mapping.system.Win32ComputerSystemMapper;
import io.github.eggy03.cimari.rest.service.OptionalCommonServiceInterface;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * <p>
 * This class executes the {@link Cimv2#WIN32_COMPUTER_SYSTEM} PowerShell command
 * and maps the resulting output into an {@link Optional} {@link Win32ComputerSystem} with default configuration.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * Win32ComputerSystemService service = new Win32ComputerSystemService();
 * Optional<Win32ComputerSystem> system = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32ComputerSystemService implements OptionalCommonServiceInterface<Win32ComputerSystem> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32ComputerSystemMapper mapper;

    /**
     * Retrieves an {@link Optional} of {@link Win32ComputerSystem}
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an {@link Optional} of {@link Win32ComputerSystem} representing
     * the HWID. Returns {@link Optional#empty()} if no information
     * is detected.
     * @since 0.1.0
     */
    @Override
    public @NonNull Optional<Win32ComputerSystem> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_COMPUTER_SYSTEM, timeout);
        return mapper.mapToObject(terminalResult.result(), Win32ComputerSystem.class);
    }
}
