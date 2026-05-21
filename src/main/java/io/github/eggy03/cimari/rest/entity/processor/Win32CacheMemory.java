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

@WmiClass(className = "Win32_CacheMemory")
@RegisterForReflection
@Schema(name = "Win32_CacheMemory",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-cachememory)"
)
public record Win32CacheMemory(

        @JsonProperty("DeviceID")
        @Schema(
                description = """
                        Unique identifier of the cache instance.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Purpose")
        @Schema(
                description = """
                        Free-form description of the cache purpose or level designation.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String purpose,

        @JsonProperty("CacheType")
        @Schema(
                description = """
                        Type of cache.

                        Possible values:
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – Instruction
                        - 4 – Data
                        - 5 – Unified
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer cacheType,

        @JsonProperty("Level")
        @Schema(
                description = """
                        Cache hierarchy level.

                        Possible values:
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – Primary (L1)
                        - 4 – Secondary (L2)
                        - 5 – Tertiary (L3)
                        - 6 – Not Applicable
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer level,

        @JsonProperty("InstalledSize")
        @Schema(
                description = """
                        Installed cache size in kilobytes.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long installedSize,

        @JsonProperty("Associativity")
        @Schema(
                description = """
                        Cache associativity.

                        Possible values:
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – Direct Mapped
                        - 4 – 2-way Set-Associative
                        - 5 – 4-way Set-Associative
                        - 6 – Fully Associative
                        - 7 – 8-way Set-Associative
                        - 8 – 16-way Set-Associative
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer associativity,

        @JsonProperty("Location")
        @Schema(
                description = """
                        Physical cache location relative to the processor.

                        Possible values:
                        - 0 – Internal
                        - 1 – External
                        - 2 – Reserved
                        - 3 – Unknown
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer location,

        @JsonProperty("ErrorCorrectType")
        @Schema(
                description = """
                        Error-correction method used by the cache.

                        Possible values:
                        - 0 – Reserved
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – None
                        - 4 – Parity
                        - 5 – Single-bit ECC
                        - 6 – Multi-bit ECC
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer errorCorrectType,

        @JsonProperty("Availability")
        @Schema(
                description = """
                        Current availability and operational state.

                        Possible values:
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – Running/Full Power
                        - 4 – Warning
                        - 5 – In Test
                        - 6 – Not Applicable
                        - 7 – Power Off
                        - 8 – Offline
                        - 9 – Off-duty
                        - 10 – Degraded
                        - 11 – Not Installed
                        - 12 – Install Error
                        - 13 – Power Save - Unknown
                        - 14 – Power Save - Low Power Mode
                        - 15 – Power Save - Standby
                        - 16 – Power Cycle
                        - 17 – Power Save - Warning
                        - 18 – Paused
                        - 19 – Not Ready
                        - 20 – Not Configured
                        - 21 – Quiesced
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer availability,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the cache device.

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

        @JsonProperty("StatusInfo")
        @Schema(
                description = """
                        Logical state of the device.

                        Possible values:
                        - 1 – Other
                        - 2 – Unknown
                        - 3 – Enabled
                        - 4 – Disabled
                        - 5 – Not Applicable
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer statusInfo

) {}