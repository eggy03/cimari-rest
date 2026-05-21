/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.peripheral;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@WmiClass(className = "Win32_Printer")
@RegisterForReflection
@Schema(
        name = "Win32_Printer",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-printer)"
)
public record Win32Printer(

        @JsonProperty("DeviceID")
        @Schema(
                description = "System-assigned unique identifier of the printer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Name of the printer as recognized by the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("Capabilities")
        @Schema(
                description = """
                        List of capability codes supported by the printer.

                        Possible values:
                        - 1 - Other
                        - 2 - Color printing
                        - 3 - Duplex printing
                        - 4 - Copies
                        - 5 - Collation
                        - 6 - Stapling
                        - 7 - Transparency printing
                        - 8 - Punch
                        - 9 - Cover
                        - 10 - Bind
                        - 11 - Black-and-white printing
                        - 12 - One-sided
                        - 13 - Two-sided long edge
                        - 14 - Two-sided short edge
                        - 15 - Portrait
                        - 16 - Landscape
                        - 17 - Reverse Portrait
                        - 18 - Reverse Landscape
                        - 19 - Quality High
                        - 20 - Quality Normal
                        - 21 - Quality Low
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> capabilities,

        @JsonProperty("CapabilityDescriptions")
        @Schema(
                description = "Descriptive text corresponding to capabilities.",
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> capabilityDescriptions,

        @JsonProperty("HorizontalResolution")
        @Schema(
                description = "Printer horizontal resolution in DPI (dots per inch).",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long horizontalResolution,

        @JsonProperty("VerticalResolution")
        @Schema(
                description = "Printer vertical resolution in DPI (dots per inch).",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long verticalResolution,

        @JsonProperty("PaperSizesSupported")
        @Schema(
                description = """
                        Numeric codes of paper sizes supported by the printer.

                        Refer to the Microsoft documentation for the exhaustive list of supported values.
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> paperSizesSupported,

        @JsonProperty("PrinterPaperNames")
        @Schema(
                description = "Names of paper types or forms supported by the printer.",
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> printerPaperNames,

        @JsonProperty("PrinterStatus")
        @Schema(
                description = """
                        Current operational state of the printer.

                        Possible values:
                        - 1 - Other
                        - 2 - Unknown
                        - 3 - Idle
                        - 4 - Printing
                        - 5 - Warm-up
                        - 6 - Stopped printing
                        - 7 - Offline
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer printerStatus,

        @JsonProperty("PrintJobDataType")
        @Schema(
                description = """
                        Data type of print jobs.

                        Example: RAW or EMF
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String printJobDataType,

        @JsonProperty("PrintProcessor")
        @Schema(
                description = """
                        Print processor used to process print jobs.

                        Example: WinPrint
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String printProcessor,

        @JsonProperty("DriverName")
        @Schema(
                description = "Name of the printer driver installed.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverName,

        @JsonProperty("Shared")
        @Schema(
                description = "Indicates whether the printer is shared on the network.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean shared,

        @JsonProperty("ShareName")
        @Schema(
                description = "Share name of the printer if it is shared.",
                nullable = true,
                type = SchemaType.STRING
        )
        String shareName,

        @JsonProperty("SpoolEnabled")
        @Schema(
                description = "Indicates whether spooling is enabled for the printer.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean spoolEnabled,

        @JsonProperty("Hidden")
        @Schema(
                description = "Specifies whether the printer is hidden from standard user interfaces.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean hidden

) {
}