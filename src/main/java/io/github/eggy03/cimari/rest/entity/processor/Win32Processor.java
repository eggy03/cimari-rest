/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.processor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Representation of a CPU device on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_Processor} WMI class.
 * </p>
 * <p>
 * See {@link Win32CacheMemory} for related cache information.
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-processor">Win32_Processor Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_Processor")
@RegisterForReflection
public record Win32Processor(

        @JsonProperty("DeviceID") String deviceId,
        @JsonProperty("Name") String name,
        @JsonProperty("NumberOfCores") Integer numberOfCores,
        @JsonProperty("NumberOfEnabledCore") Integer numberOfEnabledCores,
        @JsonProperty("ThreadCount") Integer threadCount,
        @JsonProperty("NumberOfLogicalProcessors") Integer numberOfLogicalProcessors,
        @JsonProperty("Manufacturer") String manufacturer,
        @JsonProperty("AddressWidth") Integer addressWidth,
        @JsonProperty("L2CacheSize") Integer l2CacheSize,
        @JsonProperty("L3CacheSize") Integer l3CacheSize,
        @JsonProperty("MaxClockSpeed") Integer maxClockSpeed,
        @JsonProperty("ExtClock") Integer extClock,
        @JsonProperty("SocketDesignation") String socketDesignation,
        @JsonProperty("Version") String version,
        @JsonProperty("Caption") String caption,
        @JsonProperty("Family") Integer family,
        @JsonProperty("Stepping") String stepping,
        @JsonProperty("VirtualizationFirmwareEnabled") Boolean virtualizationFirmwareEnabled,
        @JsonProperty("ProcessorId") String processorId,
        @JsonProperty("Architecture") Integer architecture
) {}