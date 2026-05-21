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

@WmiClass(className = "Win32_Baseboard")
@RegisterForReflection
@Schema(name = "Win32_Baseboard",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-baseboard)"
)
public record Win32Baseboard(

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Name of the organization responsible for producing the baseboard.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("Model")
        @Schema(
                description = "Name by which the baseboard is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String model,

        @JsonProperty("Product")
        @Schema(
                description = "Baseboard part number defined by the manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String product,

        @JsonProperty("SerialNumber")
        @Schema(
                description = "Manufacturer-allocated number used to identify the baseboard.",
                nullable = true,
                type = SchemaType.STRING
        )
        String serialNumber,

        @JsonProperty("Version")
        @Schema(
                description = "Version of the baseboard.",
                nullable = true,
                type = SchemaType.STRING
        )
        String version

) {
}