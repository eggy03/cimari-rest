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

@WmiClass(className = "Win32_VideoController")
@RegisterForReflection
@Schema(name = "Win32_VideoController",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-videocontroller)"
)
public record Win32VideoController(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Identifier (unique to the computer system) for this video controller.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Label by which the video controller is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier of the video controller.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("CurrentBitsPerPixel")
        @Schema(
                description = "Number of bits used to display each pixel.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer currentBitsPerPixel,

        @JsonProperty("CurrentHorizontalResolution")
        @Schema(
                description = "Current number of horizontal pixels.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer currentHorizontalResolution,

        @JsonProperty("CurrentVerticalResolution")
        @Schema(
                description = "Current number of vertical pixels.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer currentVerticalResolution,

        @JsonProperty("CurrentRefreshRate")
        @Schema(
                description = """
                        Frequency at which the video controller refreshes the image for the monitor.
                        
                        Unit: hertz (Hz).
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer currentRefreshRate,

        @JsonProperty("MaxRefreshRate")
        @Schema(
                description = "Maximum refresh rate of the video controller in hertz.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer maxRefreshRate,

        @JsonProperty("MinRefreshRate")
        @Schema(
                description = "Minimum refresh rate of the video controller in hertz.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer minRefreshRate,

        @JsonProperty("AdapterDACType")
        @Schema(
                description = """
                        Name or identifier of the digital-to-analog converter (DAC) chip.
                        
                        The character set of this property is alphanumeric.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String adapterDacType,

        @JsonProperty("AdapterRAM")
        @Schema(
                description = "Memory size of the video adapter in bytes.",
                nullable = true,
                type = SchemaType.INTEGER

        )
        Long adapterRam,

        @JsonProperty("DriverDate")
        @Schema(
                description = "Last modification date and time of the currently installed video driver.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverDate,

        @JsonProperty("DriverVersion")
        @Schema(
                description = "Version number of the video driver.",
                nullable = true,
                type = SchemaType.STRING
        )
        String driverVersion,

        @JsonProperty("VideoProcessor")
        @Schema(
                description = "Free-form string describing the video processor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String videoProcessor

) {
}