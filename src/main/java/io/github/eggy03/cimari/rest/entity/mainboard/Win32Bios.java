/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.mainboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@WmiClass(className = "Win32_BIOS")
@RegisterForReflection
@Schema(name = "Win32_BIOS",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-bios)"
)
public record Win32Bios(

        @JsonProperty("Name")
        @Schema(
                description = "The BIOS name.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Caption")
        @Schema(
                description = "Short description of the BIOS.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Manufacturer of the BIOS.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("ReleaseDate")
        @Schema(
                description = "BIOS release date in UTC format (YYYYMMDDHHMMSS.MMMMMM±OOO).",
                nullable = true,
                type = SchemaType.STRING
        )
        String releaseDate,

        @JsonProperty("SMBIOSPresent")
        @Schema(
                description = "If true, the SMBIOS is available on this computer system.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean smbiosPresent,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the BIOS.
                        
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

        @JsonProperty("Version")
        @Schema(
                description = "Version of the BIOS. This string is created by the BIOS manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String version,

        @JsonProperty("CurrentLanguage")
        @Schema(
                description = "Name of the current BIOS language.",
                nullable = true,
                type = SchemaType.STRING
        )
        String currentLanguage,

        @JsonProperty("SMBIOSBIOSVersion")
        @Schema(
                description = "BIOS version as reported by SMBIOS.",
                nullable = true,
                type = SchemaType.STRING
        )
        String smbiosBiosVersion,

        @JsonProperty("PrimaryBIOS")
        @Schema(
                description = "If TRUE, this is the primary BIOS of the computer system.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean primaryBios

) {
}