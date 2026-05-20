/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.mainboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;

/**
 * Immutable representation of a BIOS entity on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_BIOS} WMI class.
 * </p>
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-bios">Win32_BIOS</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_BIOS")
public record Win32Bios (
    @JsonProperty("Name") String name,
    @JsonProperty("Caption") String caption,
    @JsonProperty("Manufacturer") String manufacturer,
    @JsonProperty("ReleaseDate") String releaseDate,
    @JsonProperty("SMBIOSPresent") Boolean smbiosPresent,
    @JsonProperty("Status") String status,
    @JsonProperty("Version") String version,
    @JsonProperty("CurrentLanguage") String currentLanguage,
    @JsonProperty("SMBIOSBIOSVersion") String smbiosBiosVersion,
    @JsonProperty("PrimaryBIOS") Boolean primaryBios
){}