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
import io.github.eggy03.cimari.rest.entity.peripheral.Win32Battery;
import io.github.eggy03.cimari.rest.entity.peripheral.Win32Printer;
import io.github.eggy03.cimari.rest.entity.peripheral.Win32SoundDevice;
import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.entity.processor.Win32Processor;
import io.github.eggy03.cimari.rest.entity.storage.Win32DiskDrive;
import io.github.eggy03.cimari.rest.entity.storage.Win32DiskPartition;
import io.github.eggy03.cimari.rest.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.rest.entity.system.Win32ComputerSystem;
import io.github.eggy03.cimari.rest.entity.system.Win32Environment;
import io.github.eggy03.cimari.rest.entity.system.Win32OperatingSystem;
import io.github.eggy03.cimari.rest.entity.system.Win32PnPEntity;
import io.github.eggy03.cimari.rest.entity.system.Win32Process;
import io.github.eggy03.cimari.rest.entity.user.Win32UserAccount;
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
 * @since 0.0.1
 */
@RequiredArgsConstructor
@Getter
public enum Cimv2 {

    WIN32_DESKTOP_MONITOR(generateQuery(Win32DesktopMonitor.class)),
    WIN32_VIDEO_CONTROLLER(generateQuery(Win32VideoController.class)),

    WIN32_BASEBOARD(generateQuery(Win32Baseboard.class)),
    WIN32_PORT_CONNECTOR(generateQuery(Win32PortConnector.class)),
    WIN32_BIOS(generateQuery(Win32Bios.class)),

    WIN32_PHYSICAL_MEMORY(generateQuery(Win32PhysicalMemory.class)),

    WIN32_BATTERY(generateQuery(Win32Battery.class)),
    WIN32_PRINTER(generateQuery(Win32Printer.class)),
    WIN32_SOUND_DEVICE(generateQuery(Win32SoundDevice.class)),

    WIN32_PROCESSOR(generateQuery(Win32Processor.class)),
    WIN32_CACHE_MEMORY(generateQuery(Win32CacheMemory.class)),

    WIN32_DISK_DRIVE(generateQuery(Win32DiskDrive.class)),
    WIN32_DISK_PARTITION(generateQuery(Win32DiskPartition.class)),
    WIN32_LOGICAL_DISK(generateQuery(Win32LogicalDisk.class)),

    WIN32_COMPUTER_SYSTEM(generateQuery(Win32ComputerSystem.class)),
    WIN32_ENVIRONMENT(generateQuery(Win32Environment.class)),
    WIN32_OPERATING_SYSTEM(generateQuery(Win32OperatingSystem.class)),
    WIN32_PNP_ENTITY(generateQuery(Win32PnPEntity.class)),
    WIN32_PROCESS(generateQuery(Win32Process.class)),

    WIN32_USER_ACCOUNT(generateQuery(Win32UserAccount.class));

    private final @NonNull String query;

    private static <T> @NonNull String generateQuery(@NonNull Class<T> wmiClass) {

        return "Get-CimInstance -ClassName " + QueryUtility.getClassNameFromWmiClass(wmiClass) +
                " | Select-Object -Property " + QueryUtility.getPropertiesFromJsonProperty(wmiClass) +
                " | ConvertTo-Json";

    }
}
