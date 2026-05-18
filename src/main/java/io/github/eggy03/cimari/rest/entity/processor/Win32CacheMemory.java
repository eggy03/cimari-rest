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
 * Immutable representation of a processor cache (e.g., L1, L2, L3) on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_CacheMemory} WMI class.
 * </p>
 * <p>
 * See {@link Win32Processor} for related CPU information.
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-cachememory">Win32_CacheMemory Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_CacheMemory")
@RegisterForReflection
public record Win32CacheMemory (

    @JsonProperty("DeviceID") String deviceId,
    @JsonProperty("Purpose") String purpose,
    @JsonProperty("CacheType") Integer cacheType,
    @JsonProperty("Level") Integer level,
    @JsonProperty("InstalledSize") Long installedSize,
    @JsonProperty("Associativity") Integer associativity,
    @JsonProperty("Location") Integer location,
    @JsonProperty("ErrorCorrectType") Integer errorCorrectType,
    @JsonProperty("Availability") Integer availability,
    @JsonProperty("Status") String status,
    @JsonProperty("StatusInfo") Integer statusInfo
) {}