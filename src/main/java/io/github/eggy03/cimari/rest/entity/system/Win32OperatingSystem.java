/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.system;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

@WmiClass(className = "Win32_OperatingSystem")
@RegisterForReflection
@Schema(
        name = "Win32_OperatingSystem",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-operatingsystem)"
)
public record Win32OperatingSystem(

        @JsonProperty("Name")
        @Schema(
                description = "Name of the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Caption")
        @Schema(
                description = "Short textual description (friendly name) of the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("InstallDate")
        @Schema(
                description = "Date and time when the operating system was installed.",
                nullable = true,
                type = SchemaType.STRING
        )
        String installDate,

        @JsonProperty("CSName")
        @Schema(
                description = "Name of the computer system running the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String csName,

        @JsonProperty("LastBootUpTime")
        @Schema(
                description = "Date and time when the computer was last booted.",
                nullable = true,
                type = SchemaType.STRING
        )
        String lastBootUpTime,

        @JsonProperty("LocalDateTime")
        @Schema(
                description = "Current local date and time of the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String localDateTime,

        @JsonProperty("Distributed")
        @Schema(
                description = "Indicates whether this operating system is part of a distributed system.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean distributed,

        @JsonProperty("NumberOfUsers")
        @Schema(
                description = "Number of user sessions currently active.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer numberOfUsers,

        @JsonProperty("Version")
        @Schema(
                description = """
                        Version number of the operating system.
                        Example: "10.0.22621"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String version,

        @JsonProperty("BootDevice")
        @Schema(
                description = "Path to the boot device that the operating system uses to start the computer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String bootDevice,

        @JsonProperty("BuildNumber")
        @Schema(
                description = "Internal build number of the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String buildNumber,

        @JsonProperty("BuildType")
        @Schema(
                description = """
                        Type of build of the operating system.
                        Example: "Multiprocessor Free", "Checked"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String buildType,

        @JsonProperty("Manufacturer")
        @Schema(
                description = """
                        Manufacturer of the operating system.
                        Typically: "Microsoft Corporation"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("OSArchitecture")
        @Schema(
                description = """
                        Architecture of the operating system.
                        Example: "32-bit", "64-bit"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String osArchitecture,

        @JsonProperty("MUILanguages")
        @Schema(
                description = """
                        List of installed user interface languages (MUI language codes).
                        Example: ["en-US", "fr-FR"]
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> muiLanguages,

        @JsonProperty("PortableOperatingSystem")
        @Schema(
                description = """
                        Indicates whether the operating system is installed on a portable device.
                        
                        Possible values:
                        - true – Installed on a portable device (e.g., Windows To Go)
                        - false – Installed on a fixed computer
                        """,
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean portableOperatingSystem,

        @JsonProperty("Primary")
        @Schema(
                description = "Indicates whether this is the primary operating system on the computer.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean primary,

        @JsonProperty("RegisteredUser")
        @Schema(
                description = "Name of the registered user of the operating system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String registeredUser,

        @JsonProperty("SerialNumber")
        @Schema(
                description = "Operating system serial number or product key identifier.",
                nullable = true,
                type = SchemaType.STRING
        )
        String serialNumber,

        @JsonProperty("ServicePackMajorVersion")
        @Schema(
                description = "Major version number of the most recent service pack installed.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer servicePackMajorVersion,

        @JsonProperty("ServicePackMinorVersion")
        @Schema(
                description = "Minor version number of the most recent service pack installed.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer servicePackMinorVersion,

        @JsonProperty("SystemDirectory")
        @Schema(
                description = """
                        Full path to the system directory.
                        Example: "C:\\WINDOWS\\system32"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String systemDirectory,

        @JsonProperty("SystemDrive")
        @Schema(
                description = """
                        Drive letter where the operating system is installed.
                        Example: "C:"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String systemDrive,

        @JsonProperty("WindowsDirectory")
        @Schema(
                description = """
                        Full path to the Windows installation directory.
                        Example: "C:\\WINDOWS"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String windowsDirectory

) {
}