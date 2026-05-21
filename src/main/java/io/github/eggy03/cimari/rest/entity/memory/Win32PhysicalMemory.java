/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.memory;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigInteger;

@WmiClass(className = "Win32_PhysicalMemory")
@RegisterForReflection
@Schema(name = "Win32_PhysicalMemory",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-physicalmemory)"
)
public record Win32PhysicalMemory(

        @JsonProperty("Tag")
        @Schema(
                description = "Unique identifier for the physical memory device represented by an instance of this class.",
                nullable = true,
                type = SchemaType.STRING
        )
        String tag,

        @JsonProperty("Name")
        @Schema(
                description = "Label for the physical memory.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Name of the organization responsible for producing the physical memory.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("Model")
        @Schema(
                description = "Model name for the physical element.",
                nullable = true,
                type = SchemaType.STRING
        )
        String model,

        @JsonProperty("OtherIdentifyingInfo")
        @Schema(
                description = """
                        Additional data, beyond asset tag information, that can be used to identify
                        a physical element.
                        
                        For example, bar code data associated with an element that also has an asset tag.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String otherIdentifyingInfo,

        @JsonProperty("PartNumber")
        @Schema(
                description = """
                        Part number assigned by the organization responsible for producing
                        or manufacturing the physical element.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String partNumber,

        @JsonProperty("FormFactor")
        @Schema(
                description = """
                        Implementation form factor for the chip.
                        
                        Possible values:
                        - 0 - Unknown
                        - 1 - Other
                        - 2 - SIP
                        - 3 - DIP
                        - 4 - ZIP
                        - 5 - SOJ
                        - 6 - Proprietary
                        - 7 - SIMM
                        - 8 - DIMM
                        - 9 - TSOP
                        - 10 - PGA
                        - 11 - RIMM
                        - 12 - SODIMM
                        - 13 - SRIMM
                        - 14 - SMD
                        - 15 - SSMP
                        - 16 - QFP
                        - 17 - TQFP
                        - 18 - SOIC
                        - 19 - LCC
                        - 20 - PLCC
                        - 21 - BGA
                        - 22 - FPBGA
                        - 23 - LGA
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer formFactor,

        @JsonProperty("BankLabel")
        @Schema(
                description = "Physically labeled bank where the memory is located.",
                nullable = true,
                type = SchemaType.STRING
        )
        String bankLabel,

        @JsonProperty("Capacity")
        @Schema(
                description = "Total capacity of the physical memory in bytes.",
                nullable = true,
                type = SchemaType.STRING,
                format = "int64"
        )
        BigInteger capacity,

        @JsonProperty("DataWidth")
        @Schema(
                description = """
                        Data width of the physical memory in bits.
                        
                        A data width of 0 (zero) and a total width of 8 (eight)
                        indicates that the memory is used solely to provide error correction bits.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer dataWidth,

        @JsonProperty("Speed")
        @Schema(
                description = "Speed of the physical memory in MHz.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long speed,

        @JsonProperty("ConfiguredClockSpeed")
        @Schema(
                description = """
                        The configured clock speed of the memory device, in MHz,
                        or 0 if the speed is unknown.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long configuredClockSpeed,

        @JsonProperty("DeviceLocator")
        @Schema(
                description = "Label of the socket or circuit board that holds the memory.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceLocator,

        @JsonProperty("SerialNumber")
        @Schema(
                description = "Manufacturer-allocated number to identify the physical element.",
                nullable = true,
                type = SchemaType.STRING
        )
        String serialNumber

) {
}