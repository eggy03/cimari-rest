/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.storage;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigInteger;

@WmiClass(className = "Win32_DiskPartition")
@RegisterForReflection
@Schema(
        name = "Win32_DiskPartition",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-diskpartition)"
)
public record Win32DiskPartition(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Unique identifier of the disk drive and partition within the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Label by which the partition is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Description")
        @Schema(
                description = "Description of the partition object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("BlockSize")
        @Schema(
                description = "Size in bytes of the blocks that form this partition.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        BigInteger blockSize,

        @JsonProperty("NumberOfBlocks")
        @Schema(
                description = """
                        Total number of consecutive blocks that form this partition.

                        The total size of the partition can be calculated by
                        multiplying this value by blockSize.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        BigInteger numberOfBlocks,

        @JsonProperty("Bootable")
        @Schema(
                description = "Indicates whether the computer can be booted from this partition.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean bootable,

        @JsonProperty("PrimaryPartition")
        @Schema(
                description = "Indicates whether this is the primary partition on the disk.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean primaryPartition,

        @JsonProperty("BootPartition")
        @Schema(
                description = """
                        Indicates whether this is the active (boot) partition
                        used by the operating system when booting.
                        """,
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean bootPartition,

        @JsonProperty("DiskIndex")
        @Schema(
                description = "Index number of the physical disk that contains this partition.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long diskIndex,

        @JsonProperty("Size")
        @Schema(
                description = "Total size of the partition in bytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        BigInteger size,

        @JsonProperty("Type")
        @Schema(
                description = """
                        Type of the partition.

                        Possible Values (Non-exhaustive, will be updated when new values are found):
                        - Unused
                        - 12-bit FAT
                        - Xenix Type 1
                        - Xenix Type 2
                        - 16-bit FAT
                        - Extended Partition
                        - MS-DOS V4 Huge
                        - Installable File System
                        - PowerPC Reference Platform
                        - UNIX
                        - NTFS
                        - ReFS
                        - Win95 w/Extended Int 13
                        - Extended w/Extended Int 13
                        - Logical Disk Manager
                        - Unknown
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String type

) {}