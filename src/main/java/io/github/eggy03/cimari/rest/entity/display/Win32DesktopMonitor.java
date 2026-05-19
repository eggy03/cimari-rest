/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.display;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 * Immutable representation of a monitor device on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_DesktopMonitor} WMI class.
 * </p>
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-desktopmonitor">Win32_DesktopMonitor Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_DesktopMonitor")
@RegisterForReflection
public record Win32DesktopMonitor (

    @JsonProperty("DeviceID") String deviceId,
    @JsonProperty("Name") String name,
    @JsonProperty("PNPDeviceID") String pnpDeviceId,
    @JsonProperty("Status") String status,
    @JsonProperty("MonitorManufacturer") String monitorManufacturer,
    @JsonProperty("MonitorType") String monitorType,
    @JsonProperty("PixelsPerXLogicalInch") Integer pixelsPerXLogicalInch,
    @JsonProperty("PixelsPerYLogicalInch") Integer pixelsPerYLogicalInch
) {}