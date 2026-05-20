/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.display;

import io.github.eggy03.cimari.rest.entity.display.Win32VideoController;
import io.github.eggy03.cimari.rest.mapping.display.Win32VideoControllerMapper;
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
 * This class executes the {@link Cimv2#WIN32_VIDEO_CONTROLLER} PowerShell command
 * and maps the resulting output into an unmodifiable {@link List} of {@link Win32VideoController} objects.
 * </p>
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32VideoControllerService implements CommonServiceInterface<Win32VideoController> {

    private final @NonNull TerminalService terminalService;
    private final @NonNull Win32VideoControllerMapper mapper;

    /**
     * Retrieves an unmodifiable {@link List} of {@link Win32VideoController} objects
     * <p>
     * Each invocation creates an isolated PowerShell process, which is
     * pre-maturely terminated if execution exceeds the specified timeout.
     * </p>
     *
     * @param timeout maximum time (in seconds) to wait for the PowerShell
     *                command to complete before terminating the process
     * @return an unmodifiable {@link List} of {@link Win32VideoController} objects representing the video controllers.
     * Returns a {@link Collections#emptyList()} if none are detected.
     * @since 0.1.0
     */
    @Override
    @CacheResult(cacheName = "Win32VideoController")
    public @NonNull List<Win32VideoController> get(long timeout) {
        final TerminalResult terminalResult = terminalService.executeQuery(Cimv2.WIN32_VIDEO_CONTROLLER, timeout);
        return mapper.mapToList(terminalResult.result(), Win32VideoController.class);
    }
}