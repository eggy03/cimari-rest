/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32SoundDevice;
import io.github.eggy03.cimari.rest.mapping.peripheral.Win32SoundDeviceMapper;
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
 * This class executes the {@link Cimv2#WIN32_SOUND_DEVICE} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32SoundDevice} objects.
 * </p>
 *
 * <h2>Usage examples</h2>
 * <pre>{@code
 * Win32SoundDeviceService service = new Win32SoundDeviceService();
 * List<Win32SoundDevice> devices = service.get(10);
 * }</pre>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32SoundDeviceService implements CommonServiceInterface<Win32SoundDevice> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32SoundDeviceMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32SoundDevice} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32SoundDevice} objects representing the system's sound devices.
     * If no sound devices are present, returns a {@link Collections#emptyList()}.
     * @since 0.1.0
     */
    @Override
    public @NonNull List<Win32SoundDevice> get(long timeout) {
        TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_SOUND_DEVICE, timeout);
        return mapper.mapToList(terminalResult.result(), Win32SoundDevice.class);
    }
}
