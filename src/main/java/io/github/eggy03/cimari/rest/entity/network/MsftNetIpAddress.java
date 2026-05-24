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

@WmiClass(className = "MSFT_NetIPAddress")
@RegisterForReflection
@Schema(
        name = "MSFT_NetIPAddress",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/fwp/wmi/nettcpipprov/msft-netipaddress)"
)
public record MsftNetIpAddress(

        @JsonProperty("InterfaceIndex")
        @Schema(
                description = "Index of the network interface associated with this IP configuration.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceIndex,

        @JsonProperty("InterfaceAlias")
        @Schema(
                description = "User-friendly name of the network interface.",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceAlias,

        @JsonProperty("AddressFamily")
        @Schema(
                description = """
                        Address family of the IP address.
                        
                        Possible values:
                        - IPv4 (2)
                        - IPv6 (23)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long addressFamily,

        @JsonProperty("IPAddress")
        @Schema(
                description = "IP address assigned to the interface.",
                nullable = true,
                type = SchemaType.STRING
        )
        String ipAddress,

        @JsonProperty("IPv4Address")
        @Schema(
                description = "IPv4 address assigned to the interface, if applicable.",
                nullable = true,
                type = SchemaType.STRING
        )
        String ipv4Address,

        @JsonProperty("IPv6Address")
        @Schema(
                description = "IPv6 address assigned to the interface, if applicable.",
                nullable = true,
                type = SchemaType.STRING
        )
        String ipv6Address,

        @JsonProperty("Type")
        @Schema(
                description = """
                        Type of IP address.
                        
                        Possible values:
                        - Unicast (1)
                        - Anycast (2)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer type,

        @JsonProperty("PrefixOrigin")
        @Schema(
                description = """
                        Source of the prefix for this IP address.
                        
                        Possible values:
                        - Other (0)
                        - Manual (1)
                        - WellKnown (2)
                        - DHCP (3)
                        - RouterAdvertisement (4)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long prefixOrigin,

        @JsonProperty("SuffixOrigin")
        @Schema(
                description = """
                        Source of the suffix for this IP address.
                        
                        Possible values:
                        - Other (0)
                        - Manual (1)
                        - WellKnown (2)
                        - DHCP (3)
                        - Link (4)
                        - Random (5)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long suffixOrigin,

        @JsonProperty("PrefixLength")
        @Schema(
                description = "Length of the network prefix in bits.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long prefixLength,

        @JsonProperty("PreferredLifetime")
        @Schema(
                description = "Lifetime during which the address is preferred for use.",
                nullable = true,
                implementation = Datetime.class
        )
        Datetime preferredLifetime,

        @JsonProperty("ValidLifetime")
        @Schema(
                description = "Total lifetime during which the address is valid.",
                nullable = true,
                implementation = Datetime.class
        )
        Datetime validLifeTime

) {

    @RegisterForReflection
    @Schema(name = "Datetime", description = "Datetime object for MSFT_NetIPAddress")
    public record Datetime(

            @JsonProperty("Days")
            @Schema(
                    description = "Number of days.",
                    nullable = true,
                    type = SchemaType.INTEGER
            )
            Long days,

            @JsonProperty("Hours")
            @Schema(
                    description = "Number of hours.",
                    nullable = true,
                    type = SchemaType.INTEGER
            )
            Long hours,

            @JsonProperty("Minutes")
            @Schema(
                    description = "Number of minutes.",
                    nullable = true,
                    type = SchemaType.INTEGER
            )
            Long minutes,

            @JsonProperty("Seconds")
            @Schema(
                    description = "Number of seconds.",
                    nullable = true,
                    type = SchemaType.INTEGER
            )
            Long seconds

    ) {
    }

}