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

@WmiClass(className = "MSFT_NetAdapter")
@RegisterForReflection
@Schema(
        name = "MSFT_NetAdapter",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/fwp/wmi/netadaptercimprov/msft-netadapter)"
)
public record MsftNetAdapter(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Uniquely identifies the network adapter on the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("PnPDeviceID")
        @Schema(
                description = "Plug and Play (PnP) device identifier assigned to the adapter by Windows.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("InterfaceIndex")
        @Schema(
                description = " Unique interface index number used by the network stack.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceIndex,

        @JsonProperty("InterfaceName")
        @Schema(
                description = "Name of the network adapter interface.",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceName,

        @JsonProperty("InterfaceType")
        @Schema(
                description = "Type of interface as defined by the IANA Interface Type registry.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceType,

        @JsonProperty("InterfaceDescription")
        @Schema(
                description = """
                        Interface description, also known as ifDesc or display name.
                        
                        This is a unique name assigned to the network adapter during installation.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceDescription,

        @JsonProperty("InterfaceAlias")
        @Schema(
                description = "Friendly alias name assigned to the network interface.",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceAlias,

        @JsonProperty("InterfaceOperationalStatus")
        @Schema(
                description = """
                        Current operational status of the network adapter interface.
                        
                        Possible values:
                        - Up (1)
                        - Down (2)
                        - Testing (3)
                        - Unknown (4)
                        - Dormant (5)
                        - NotPresent (6)
                        - LowerLayerDown (7)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long interfaceOperationalStatus,

        @JsonProperty("Virtual")
        @Schema(
                description = "Indicates whether this adapter represents a virtual interface.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean virtual,

        @JsonProperty("FullDuplex")
        @Schema(
                description = "Indicates whether the adapter supports full-duplex mode.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean fullDuplex,

        @JsonProperty("Hidden")
        @Schema(
                description = "Indicates whether the adapter is hidden from the user interface.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean hidden,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the network adapter device.
                        
                        Possible OPERATIONAL values:
                        - OK
                        - Degraded
                        - Pred Fail
                        
                        Possible NON-OPERATIONAL values:
                        - Unknown
                        - Error
                        - Starting
                        - Stopping
                        - Service
                        
                        Possible OTHER values:
                        - Stressed
                        - NonRecover
                        - No Contact
                        - Lost Comm
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String status,

        @JsonProperty("LinkLayerAddress")
        @Schema(
                description = "Physical MAC address of the network adapter.",
                nullable = true,
                type = SchemaType.STRING
        )
        String linkLayerAddress,

        @JsonProperty("LinkSpeed")
        @Schema(
                description = "Current link speed as a formatted string.",
                nullable = true,
                type = SchemaType.STRING
        )
        String linkSpeed,

        @JsonProperty("ReceiveLinkSpeed")
        @Schema(
                description = "Raw value of the current receive link speed in bits per second.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long receiveLinkSpeedRaw,

        @JsonProperty("TransmitLinkSpeed")
        @Schema(
                description = "Raw value of the current transmit link speed in bits per second.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long transmitLinkSpeedRaw,

        @JsonProperty("DriverName")
        @Schema(
                description = "Name of the network adapter driver.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverName,

        @JsonProperty("DriverVersion")
        @Schema(
                description = "Version number of the network adapter driver.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverVersion,

        @JsonProperty("DriverDate")
        @Schema(
                description = "Date of the currently installed driver.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverDate,

        @JsonProperty("MtuSize")
        @Schema(
                description = "Maximum Transmission Unit (MTU) size of the adapter in bytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long mtuSize,

        @JsonProperty("MediaConnectState")
        @Schema(
                description = """
                        Current media connection state of the adapter.
                        
                        Possible values:
                        - Unknown (0)
                        - Connected (1)
                        - Disconnected (2)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long mediaConnectState,

        @JsonProperty("NdisMedium")
        @Schema(
                description = """
                        Network adapter media type.
                        
                        Numeric equivalent of mediaType.
                        
                        Possible values:
                        - 802.3 (0)
                        - 802.5 (1)
                        - FDDI (2)
                        - WAN (3)
                        - LocalTalk (4)
                        - DIX (5)
                        - Raw Arcnet (6)
                        - 878.2 (7)
                        - ATM (8)
                        - Wireless WAN (9)
                        - IrDA (10)
                        - BPC (11)
                        - Connection Oriented WAN (12)
                        - IP 1394 (13)
                        - InfiniBand (14)
                        - Tunnel (15)
                        - Native 802.11 (16)
                        - Loopback (17)
                        - WiMAX (18)
                        - IP (19)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long ndisMedium,

        @JsonProperty("NdisPhysicalMedium")
        @Schema(
                description = """
                        Physical media type supported by the network adapter.
                        
                        Numeric equivalent of physicalMediaType.
                        
                        Possible values:
                        - Unspecified (0)
                        - Wireless LAN (1)
                        - Cable Modem (2)
                        - Phone Line (3)
                        - Power Line (4)
                        - DSL (5)
                        - Fibre Channel (6)
                        - IEEE 1394 (7)
                        - Wireless WAN (8)
                        - Native 802.11 (9)
                        - Bluetooth (10)
                        - InfiniBand (11)
                        - WiMAX (12)
                        - Ultra-Wideband (13)
                        - 802.3 (14)
                        - 802.5 (15)
                        - IrDA (16)
                        - Wired WAN (17)
                        - Wired Connection Oriented WAN (18)
                        - Other (19)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long ndisPhysicalMedium,

        @JsonProperty("MediaType")
        @Schema(
                description = "Type of network media currently in use.",
                nullable = true,
                type = SchemaType.STRING
        )
        String mediaType,

        @JsonProperty("PhysicalMediaType")
        @Schema(
                description = "Physical type of network media.",
                nullable = true,
                type = SchemaType.STRING
        )
        String physicalMediaType

) {
}