/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@WmiClass(className = "Win32_PnPEntity")
@RegisterForReflection
@Schema(
        name = "Win32_PnPEntity",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-pnpentity)"
)
public record Win32PnPEntity(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Identifier of the Plug and Play device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier of the logical device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("HardwareID")
        @Schema(
                description = """
                        Vendor-defined list of hardware identification strings used by Windows Setup
                        to match the device to an INF file.
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> hardwareId,

        @JsonProperty("CompatibleID")
        @Schema(
                description = """
                        Vendor-defined list of compatible identification strings used by Windows Setup
                        as fallback identifiers when no matching hardware ID is found.
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> compatibleId,

        @JsonProperty("Name")
        @Schema(
                description = "The name by which the device is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Description")
        @Schema(
                description = "Human-readable description of the device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Name of the manufacturer of the Plug and Play device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("Present")
        @Schema(
                description = """
                        Indicates whether this Plug and Play device is currently present in the system.
                        
                        Note:
                        This property is not supported on:
                        - Windows Server 2012 R2
                        - Windows 8.1
                        - Windows Server 2012
                        - Windows 8
                        - Windows Server 2008 R2
                        - Windows 7
                        - Windows Server 2008
                        - Windows Vista
                        """,
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean present,

        @JsonProperty("Status")
        @Schema(description = """
                Current operational status of the Plug and Play device.
                
                Possible OPERATIONAL values:
                - "OK"
                - "Degraded"
                - "Pred Fail"
                
                Possible NON-OPERATIONAL values:
                - "Unknown"
                - "Error"
                - "Starting"
                - "Stopping"
                - "Service"
                
                Possible OTHER values:
                - "Stressed"
                - "NonRecover"
                - "No Contact"
                - "Lost Comm"
                """,
                nullable = true,
                type = SchemaType.STRING
        )
        String status

) {
}