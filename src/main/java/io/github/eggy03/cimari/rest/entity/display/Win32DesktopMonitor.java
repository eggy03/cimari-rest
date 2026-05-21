/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.display;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@WmiClass(className = "Win32_DesktopMonitor")
@RegisterForReflection
@Schema(name = "Win32_DesktopMonitor",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-desktopmonitor)"
)
public record Win32DesktopMonitor(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Unique identifier of the desktop monitor on the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Label by which the object is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier of the monitor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the monitor device.
                        
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

        @JsonProperty("MonitorManufacturer")
        @Schema(
                description = "Name of the manufacturer of the monitor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String monitorManufacturer,

        @JsonProperty("MonitorType")
        @Schema(
                description = "Type of monitor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String monitorType,

        @JsonProperty("PixelsPerXLogicalInch")
        @Schema(
                description = "Resolution along the x-axis (horizontal direction) of the monitor.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer pixelsPerXLogicalInch,

        @JsonProperty("PixelsPerYLogicalInch")
        @Schema(
                description = "Resolution along the y-axis (vertical direction) of the monitor.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer pixelsPerYLogicalInch

) {
}