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
import java.util.List;

@WmiClass(className = "Win32_DiskDrive")
@RegisterForReflection
@Schema(
        name = "Win32_DiskDrive",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-diskdrive)"
)
public record Win32DiskDrive(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Unique identifier of the disk drive with other devices on the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Caption")
        @Schema(
                description = "Short description of the object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Model")
        @Schema(
                description = "Manufacturer’s model number of the disk drive.",
                nullable = true,
                type = SchemaType.STRING
        )
        String model,

        @JsonProperty("Size")
        @Schema(
                description = """
                        Size of the disk drive, calculated by multiplying the total number
                        of cylinders, tracks in each cylinder, sectors in each track,
                        and bytes in each sector.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        BigInteger size,

        @JsonProperty("FirmwareRevision")
        @Schema(
                description = "Revision of the disk drive firmware assigned by the manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String firmwareRevision,

        @JsonProperty("SerialNumber")
        @Schema(
                description = "Number allocated by the manufacturer to identify the physical media.",
                nullable = true,
                type = SchemaType.STRING
        )
        String serialNumber,

        @JsonProperty("Partitions")
        @Schema(
                description = "Number of partitions on this physical disk drive recognized by the operating system.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long partitions,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the physical disk.

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

        @JsonProperty("InterfaceType")
        @Schema(
                description = "Interface type of the physical disk drive (e.g., SCSI, IDE, USB, NVMe).",
                nullable = true,
                type = SchemaType.STRING
        )
        String interfaceType,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier of the logical device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("Capabilities")
        @Schema(
                description = """
                        Array of capabilities of the media access device.

                        Possible Values:
                        - 1 - Other
                        - 2 - Sequential Access
                        - 3 - Random Access
                        - 4 - Supports Writing
                        - 5 - Encryption
                        - 6 - Compression
                        - 7 - Supports Removable Media
                        - 8 - Manual Cleaning
                        - 9 - Automatic Cleaning
                        - 10 - S.M.A.R.T Notification
                        - 11 - Supports Dual Sided Media
                        - 12 - Pre-dismount Eject Not Required
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> capabilities,

        @JsonProperty("CapabilityDescriptions")
        @Schema(
                description = """
                        List of more detailed explanations for any of the access device
                        features indicated in the capabilities array.

                        Each entry of this array is related to the entry in the
                        capabilities array located at the same index.
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> capabilityDescriptions

) {}