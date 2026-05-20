/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.shell.query;

import io.github.eggy03.cimari.rest.entity.display.Win32DesktopMonitor;
import io.github.eggy03.cimari.rest.entity.display.Win32VideoController;
import io.github.eggy03.cimari.rest.entity.mainboard.Win32Baseboard;
import io.github.eggy03.cimari.rest.entity.mainboard.Win32Bios;
import io.github.eggy03.cimari.rest.entity.mainboard.Win32PortConnector;
import io.github.eggy03.cimari.rest.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.entity.processor.Win32Processor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing the predefined WMI Win32 Class queries for the classes available in the {@code root/cimv2} namespace.
 * <p>
 * Each constant holds a PowerShell query that queries a specific class in the namespace
 * and returns the result in JSON format.
 * </p>
 *
 * @since 0.1.0
 */
@RequiredArgsConstructor
@Getter
public enum Cimv2 {

    WIN32_PROCESSOR(generateQuery(Win32Processor.class)),
    WIN32_CACHE_MEMORY(generateQuery(Win32CacheMemory.class)),

    WIN32_PHYSICAL_MEMORY(generateQuery(Win32PhysicalMemory.class)),

    WIN32_DESKTOP_MONITOR(generateQuery(Win32DesktopMonitor.class)),
    WIN32_VIDEO_CONTROLLER(generateQuery(Win32VideoController.class)),

    WIN32_BASEBOARD(generateQuery(Win32Baseboard.class)),
    WIN32_PORT_CONNECTOR(generateQuery(Win32PortConnector.class)),
    WIN32_BIOS(generateQuery(Win32Bios.class));

    private final @NonNull String query;

    private static <T> @NonNull String generateQuery(@NonNull Class<T> wmiClass) {

        return "Get-CimInstance -ClassName " + QueryUtility.getClassNameFromWmiClass(wmiClass) +
                " | Select-Object -Property " + QueryUtility.getPropertiesFromJsonProperty(wmiClass) +
                " | ConvertTo-Json";

    }
}
