/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.network;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@WmiClass(className = "MSFT_DNSClientServerAddress")
@RegisterForReflection
@Schema(
        name = "MSFT_DNSClientServerAddress",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/fwp/wmi/dnsclientcimprov/msft-dnsclientserveraddress)"
)
public record MsftDnsClientServerAddress(

        @JsonProperty("InterfaceIndex")
        @Schema(
                description = """
                        Gets the user-friendly index of the server interface.

                        It's the unique interface index number used by the network stack.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceIndex,

        @JsonProperty("InterfaceAlias")
        @Schema(
                description = "Gets the user-friendly name of the server interface.",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceAlias,

        @JsonProperty("AddressFamily")
        @Schema(
                description = """
                        Gets the address family of the server address.

                        Possible values:
                        - 2  - IPv4
                        - 23 - IPv6
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer addressFamily,

        @JsonProperty("ServerAddresses")
        @Schema(
                description = "Gets a list that contains the DNS server addresses.",
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> dnsServerAddresses

) {}