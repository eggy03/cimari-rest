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

@WmiClass(className = "MSFT_NetConnectionProfile")
@RegisterForReflection
@Schema(
        name = "MSFT_NetConnectionProfile",
        description = "[Documentation](https://wutils.com/wmi/root/standardcimv2/msft_netconnectionprofile/)"
)
public record MsftNetConnectionProfile(

        @JsonProperty("InterfaceIndex")
        @Schema(
                description = "Interface index of the network interface on which the profile is connected.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceIndex,

        @JsonProperty("InterfaceAlias")
        @Schema(
                description = "Name of the network interface on which the profile is connected.",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceAlias,

        @JsonProperty("NetworkCategory")
        @Schema(
                description = """
                        Network category of the connected profile.

                        Possible values:
                        - Public (0)
                        - Private (1)
                        - DomainAuthenticated (2)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long networkCategory,

        @JsonProperty("DomainAuthenticationKind")
        @Schema(
                description = """
                        Indicates the domain authentication kind associated with the profile.

                        WARNING: No official Microsoft documentation was found for this field.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long domainAuthenticationKind,

        @JsonProperty("IPv4Connectivity")
        @Schema(
                description = """
                        IPv4 connectivity status of the connected profile.

                        Possible values:
                        - Disconnected (0)
                        - NoTraffic (1)
                        - Subnet (2)
                        - LocalNetwork (3)
                        - Internet (4)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long ipv4Connectivity,

        @JsonProperty("IPv6Connectivity")
        @Schema(
                description = """
                        IPv6 connectivity status of the connected profile.

                        Possible values:
                        - Disconnected (0)
                        - NoTraffic (1)
                        - Subnet (2)
                        - LocalNetwork (3)
                        - Internet (4)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long ipv6Connectivity

) {}