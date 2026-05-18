/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.memory;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;

import java.math.BigInteger;

/**
 * Immutable representation of a RAM module on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_PhysicalMemory} WMI class.
 * </p>
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-physicalmemory">Win32_PhysicalMemory Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_PhysicalMemory")
public record Win32PhysicalMemory (
        
    @JsonProperty("Tag") String tag,
    @JsonProperty("Name") String name,
    @JsonProperty("Manufacturer") String manufacturer,
    @JsonProperty("Model") String model,
    @JsonProperty("OtherIdentifyingInfo") String otherIdentifyingInfo,
    @JsonProperty("PartNumber") String partNumber,
    @JsonProperty("FormFactor") Integer formFactor,
    @JsonProperty("BankLabel") String bankLabel,
    @JsonProperty("Capacity") BigInteger capacity,
    @JsonProperty("DataWidth") Integer dataWidth,
    @JsonProperty("Speed") Long speed,
    @JsonProperty("ConfiguredClockSpeed") Long configuredClockSpeed,
    @JsonProperty("DeviceLocator") String deviceLocator,
    @JsonProperty("SerialNumber") String serialNumber
){ }
