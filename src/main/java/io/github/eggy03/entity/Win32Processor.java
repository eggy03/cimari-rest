/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@NoArgsConstructor
@RegisterForReflection
public class Win32Processor {

    /**
     * Unique identifier of the processor on the system.
     */
    @JsonProperty("DeviceID")
    public String deviceId;

    /**
     * Processor name: Typically includes manufacturer, brand, and model information.
     */
    @JsonProperty("Name")
    public String name;

    /**
     * Number of physical cores on the processor.
     */
    @JsonProperty("NumberOfCores")
    public Integer numberOfCores;

    /**
     * Number of enabled processor cores.
     */
    @JsonProperty("NumberOfEnabledCore")
    public Integer numberOfEnabledCores;

    /**
     * Number of hardware threads across all cores.
     */
    @JsonProperty("ThreadCount")
    public Integer threadCount;

    /**
     * Number of logical processors on the system.
     */
    @JsonProperty("NumberOfLogicalProcessors")
    public Integer numberOfLogicalProcessors;

    /**
     * Name of the processor manufacturer.
     */
    @JsonProperty("Manufacturer")
    public String manufacturer;

    /**
     * Width of the processor address bus in bits.
     * For a 32-bit CPU the value is 32 and for a 64-bit CPU, the value is 64
     */
    @JsonProperty("AddressWidth")
    public Integer addressWidth;

    /**
     * Size of the Level 2 cache in kilobytes.
     */
    @JsonProperty("L2CacheSize")
    public Integer l2CacheSize;

    /**
     * Size of the Level 3 cache in kilobytes.
     */
    @JsonProperty("L3CacheSize")
    public Integer l3CacheSize;

    /**
     * Maximum speed of the processor in megahertz under normal operating conditions.
     */
    @JsonProperty("MaxClockSpeed")
    public Integer maxClockSpeed;

    /**
     * External clock frequency of the processor in megahertz.
     */
    @JsonProperty("ExtClock")
    public Integer extClock;

    /**
     * Type of socket or slot used by the processor.
     */
    @JsonProperty("SocketDesignation")
    public String socketDesignation;

    /**
     * Version of the processor as reported by the manufacturer.
     */
    @JsonProperty("Version")
    public String version;

    /**
     * Short textual description of the processor.
     */
    @JsonProperty("Caption")
    public String caption;

    /**
     * Processor family type. Indicates the manufacturer and generation of the processor.
     */
    @JsonProperty("Family")
    public Integer family;

    /**
     * Stepping information for the processor revision.
     */
    @JsonProperty("Stepping")
    public String stepping;

    /**
     * Indicates whether virtualization technology is enabled in firmware.
     */
    @JsonProperty("VirtualizationFirmwareEnabled")
    public Boolean virtualizationFirmwareEnabled;

    /**
     * Processor identifier string, which may include family, model, and stepping information.
     */
    @JsonProperty("ProcessorId")
    public String processorId;

    /**
     * Processor architecture used by the platform.
     * <p>Possible Values:</p>
     * <ul>
     *     <li>x86 (0)</li>
     *     <li>MIPS (1)</li>
     *     <li>Alpha (2)</li>
     *     <li>PowerPC (3)</li>
     *     <li>ARM (5)</li>
     *     <li>ia64 (6)</li>
     *     <li>x64 (9)</li>
     *     <li>ARM64 (12)</li>
     * </ul>
     */
    @JsonProperty("Architecture")
    public Integer architecture;

}