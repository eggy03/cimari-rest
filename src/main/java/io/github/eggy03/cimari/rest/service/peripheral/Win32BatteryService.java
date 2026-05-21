/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.peripheral;
import io.github.eggy03.cimari.rest.entity.peripheral.Win32Battery;
import io.github.eggy03.cimari.rest.mapping.peripheral.Win32BatteryMapper;
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
 * This class executes the {@link Cimv2#WIN32_BATTERY} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32Battery} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * Win32BatteryService service = new Win32BatteryService();
 * List<Win32Battery> batteries = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32BatteryService implements CommonServiceInterface<Win32Battery> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32BatteryMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32Battery} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32Battery} objects representing the system's batteries.
     * If no batteries are present, returns a {@link Collections#emptyList()}.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<Win32Battery> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_BATTERY, timeout);
        return mapper.mapToList(terminalResult.result(), Win32Battery.class);
    }
}