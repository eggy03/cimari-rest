/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.mainboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;

/**
 * Immutable representation of a motherboard device on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_Baseboard} WMI class.
 * </p>
 *
 * <p>
 * {@link Win32PortConnector} contains details about ports on this mainboard.
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-baseboard">Win32_Baseboard Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_Baseboard")
public record Win32Baseboard (
    @JsonProperty("Manufacturer") String manufacturer,
    @JsonProperty("Model") String model,
    @JsonProperty("Product") String product,
    @JsonProperty("SerialNumber") String serialNumber,
    @JsonProperty("Version") String version
) {}