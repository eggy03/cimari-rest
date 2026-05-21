/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.shell.query;

import io.github.eggy03.cimari.rest.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.cimari.rest.entity.network.MsftNetAdapter;
import io.github.eggy03.cimari.rest.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.cimari.rest.entity.network.MsftNetIpAddress;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Enum representing the predefined MSFT Class queries for the classes available in the {@code root/StandardCimv2} namespace.
 * <p>
 * Each constant holds a PowerShell query that queries a specific class in the namespace
 * and returns the result in JSON format.
 * </p>
 *
 * @since 0.1.0
 */
@RequiredArgsConstructor
@Getter
public enum StandardCimv2 {

    MSFT_NET_ADAPTER(generateQuery("Get-NetAdapter", MsftNetAdapter.class)),
    MSFT_NET_IP_ADDRESS(generateQuery("Get-NetIPAddress", MsftNetIpAddress.class)),
    MSFT_NET_DNS_CLIENT_SERVER_ADDRESS(generateQuery("Get-DNSClientServerAddress", MsftDnsClientServerAddress.class)),
    MSFT_NET_CONNECTION_PROFILE(generateQuery("Get-NetConnectionProfile", MsftNetConnectionProfile.class));

    private final @NonNull String query;

    private static @NonNull <T> String generateQuery(@NonNull String prefix, @NonNull Class<T> wmiClass) {

        return prefix +
                " | Select-Object -Property " + QueryUtility.getPropertiesFromJsonProperty(wmiClass) +
                " | ConvertTo-Json";

    }
}
