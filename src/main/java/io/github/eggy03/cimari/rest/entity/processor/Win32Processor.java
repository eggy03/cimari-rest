/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.processor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@WmiClass(className = "Win32_Processor")
@RegisterForReflection
@Schema(name = "Win32_Processor",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-processor)"
)
public record Win32Processor(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Unique identifier of the processor on the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Processor name. Typically includes manufacturer, brand, and model information.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("NumberOfCores")
        @Schema(
                description = "Number of physical cores on the processor.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer numberOfCores,

        @JsonProperty("NumberOfEnabledCore")
        @Schema(
                description = "Number of enabled processor cores.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer numberOfEnabledCores,

        @JsonProperty("ThreadCount")
        @Schema(
                description = "Number of hardware threads across all cores.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer threadCount,

        @JsonProperty("NumberOfLogicalProcessors")
        @Schema(
                description = "Number of logical processors on the system.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer numberOfLogicalProcessors,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Name of the processor manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("AddressWidth")
        @Schema(
                description = """
                        Width of the processor address bus in bits.
                        
                        For a 32-bit CPU the value is 32 and for a 64-bit CPU,
                        the value is 64.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer addressWidth,

        @JsonProperty("L2CacheSize")
        @Schema(
                description = "Size of the Level 2 cache in kilobytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer l2CacheSize,

        @JsonProperty("L3CacheSize")
        @Schema(
                description = "Size of the Level 3 cache in kilobytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer l3CacheSize,

        @JsonProperty("MaxClockSpeed")
        @Schema(
                description = """
                        Maximum speed of the processor in megahertz
                        under normal operating conditions.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer maxClockSpeed,

        @JsonProperty("ExtClock")
        @Schema(
                description = "External clock frequency of the processor in megahertz.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer extClock,

        @JsonProperty("SocketDesignation")
        @Schema(
                description = "Type of socket or slot used by the processor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String socketDesignation,

        @JsonProperty("Version")
        @Schema(
                description = "Version of the processor as reported by the manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String version,

        @JsonProperty("Caption")
        @Schema(
                description = "Short textual description of the processor.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Family")
        @Schema(
                description = """
                        Processor family type.
                        
                        Indicates the manufacturer and generation of the processor.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer family,

        @JsonProperty("Stepping")
        @Schema(
                description = "Stepping information for the processor revision.",
                nullable = true,
                type = SchemaType.STRING
        )
        String stepping,

        @JsonProperty("VirtualizationFirmwareEnabled")
        @Schema(
                description = "Indicates whether virtualization technology is enabled in firmware.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean virtualizationFirmwareEnabled,

        @JsonProperty("ProcessorId")
        @Schema(
                description = """
                        Processor identifier string, which may include family,
                        model, and stepping information.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String processorId,

        @JsonProperty("Architecture")
        @Schema(
                description = """
                        Processor architecture used by the platform.
                        
                        Possible values:
                        - x86 (0)
                        - MIPS (1)
                        - Alpha (2)
                        - PowerPC (3)
                        - ARM (5)
                        - ia64 (6)
                        - x64 (9)
                        - ARM64 (12)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer architecture

) {
}