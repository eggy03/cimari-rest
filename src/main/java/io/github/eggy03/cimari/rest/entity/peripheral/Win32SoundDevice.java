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

@WmiClass(className = "Win32_SoundDevice")
@RegisterForReflection
@Schema(
        name = "Win32_SoundDevice",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-sounddevice)"
)
public record Win32SoundDevice(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Unique identifier of the sound device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("PNPDeviceID")
        @Schema(
                description = "Windows Plug and Play device identifier.",
                nullable = true,
                type = SchemaType.STRING
        )
        String pnpDeviceId,

        @JsonProperty("Name")
        @Schema(
                description = "Friendly name of the sound device as recognized by the system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Manufacturer of the sound device.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the sound device.

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
                        Numeric state of the logical device.

                        Possible values:
                        - 1 - Other
                        - 2 - Unknown
                        - 3 - Enabled
                        - 4 - Disabled
                        - 5 - Not Applicable
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer statusInfo

) {}