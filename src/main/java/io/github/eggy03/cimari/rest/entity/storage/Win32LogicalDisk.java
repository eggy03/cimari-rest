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

@WmiClass(className = "Win32_LogicalDisk")
@RegisterForReflection
@Schema(
        name = "Win32_LogicalDisk",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-logicaldisk)"
)
public record Win32LogicalDisk(

        @JsonProperty("DeviceID")
        @Schema(
                description = """
                        Unique identifier of the logical disk from other devices on the system.
                        Appears as the drive letter assigned to the partition in the physical disk
                        Example: "C:"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Description")
        @Schema(
                description = "Description of the logical disk object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("DriveType")
        @Schema(
                description = """
                        Numeric value that corresponds to the type of disk drive this logical disk represents.
                        
                        Possible values:
                        - 0 – Unknown
                        - 1 – No Root Directory
                        - 2 – Removable Disk
                        - 3 – Local Disk
                        - 4 – Network Drive
                        - 5 – Compact Disc
                        - 6 – RAM Disk
                        
                        Data type: uint32
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long driveType,

        @JsonProperty("MediaType")
        @Schema(
                description = """
                        Type of media currently present in the logical drive.
                        Value corresponds to a member of the MEDIA_TYPE enumeration defined in Winioctl.h.
                        Visit the microsoft documentation stated at the class level to know about the possible values.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long mediaType,

        @JsonProperty("FileSystem")
        @Schema(
                description = """
                        File system on the logical disk.
                        Example: "NTFS", "FAT32", "ReFS"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String fileSystem,

        @JsonProperty("Size")
        @Schema(
                description = "Size of the disk drive in bytes.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger size,

        @JsonProperty("FreeSpace")
        @Schema(
                description = "Free space, in bytes, available on the logical disk.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger freeSpace,

        @JsonProperty("Compressed")
        @Schema(
                description = """
                        Indicates if the logical volume exists as a single compressed entity (e.g., DoubleSpace).
                        If file-based compression is supported (e.g., NTFS), this value is false.
                        """,
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean compressed,

        @JsonProperty("SupportsFileBasedCompression")
        @Schema(
                description = "Indicates whether the logical disk supports file-based compression (e.g., NTFS).",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean supportsFileBasedCompression,

        @JsonProperty("SupportsDiskQuotas")
        @Schema(
                description = "Indicates whether this volume supports disk quotas.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean supportsDiskQuotas,

        @JsonProperty("VolumeName")
        @Schema(
                description = """
                        Volume name of the logical disk.
                        Example: "Local Disk"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String volumeName,

        @JsonProperty("VolumeSerialNumber")
        @Schema(
                description = "Volume serial number of the logical disk.",
                nullable = true,
                type = SchemaType.STRING
        )
        String volumeSerialNumber

) {
}