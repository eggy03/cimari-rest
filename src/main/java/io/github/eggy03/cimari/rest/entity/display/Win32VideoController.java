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
 * Immutable representation of a GPU device on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_VideoController} WMI class.
 * </p>
 *
 * <p>
 * Hardware that is not compatible with Windows Display Driver Model (WDDM) returns inaccurate
 * property values for instances of this class.
 * </p>
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-videocontroller">Win32_VideoController Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_VideoController")
@RegisterForReflection
public record Win32VideoController (

    @JsonProperty("DeviceID") String deviceId,
    @JsonProperty("Name") String name,
    @JsonProperty("PNPDeviceID") String pnpDeviceId,
    @JsonProperty("CurrentBitsPerPixel") Integer currentBitsPerPixel,
    @JsonProperty("CurrentHorizontalResolution") Integer currentHorizontalResolution,
    @JsonProperty("CurrentVerticalResolution") Integer currentVerticalResolution,
    @JsonProperty("CurrentRefreshRate") Integer currentRefreshRate,
    @JsonProperty("MaxRefreshRate") Integer maxRefreshRate,
    @JsonProperty("MinRefreshRate") Integer minRefreshRate,
    @JsonProperty("AdapterDACType") String adapterDacType,
    @JsonProperty("AdapterRAM") Long adapterRam,
    @JsonProperty("DriverDate") String driverDate,
    @JsonProperty("DriverVersion") String driverVersion,
    @JsonProperty("VideoProcessor") String videoProcessor
){}