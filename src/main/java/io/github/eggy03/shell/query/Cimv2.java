/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.shell.query;

import io.github.eggy03.entity.Win32Processor;
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

    /**
     * Query to fetch the properties of {@code Win32_Processor} class
     *
     * @since 0.1.0
     */
    WIN32_PROCESSOR(generateQuery(Win32Processor.class));

    private final @NonNull String query;

    private static <T> @NonNull String generateQuery(@NonNull Class<T> wmiClass) {

        return "Get-CimInstance -ClassName " + QueryUtility.getClassNameFromWmiClass(wmiClass) +
                " | Select-Object -Property " + QueryUtility.getPropertiesFromJsonProperty(wmiClass) +
                " | ConvertTo-Json";

    }
}
