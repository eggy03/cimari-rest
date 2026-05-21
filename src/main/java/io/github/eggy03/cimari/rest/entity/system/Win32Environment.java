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

@WmiClass(className = "Win32_Environment")
@RegisterForReflection
@Schema(
        name = "Win32_Environment",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-environment)"
)
public record Win32Environment(

        @JsonProperty("Name")
        @Schema(
                description = "Character string that specifies the name of a Windows-based environment variable.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("SystemVariable")
        @Schema(
                description = "Indicates whether the variable is a system variable.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean systemVariable,

        @JsonProperty("VariableValue")
        @Schema(
                description = """
                        Placeholder variable of a Windows-based environment variable.
                        Information such as file system directories can change from computer to computer.
                        The operating system substitutes placeholders for these values.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String variableValue

) {
}