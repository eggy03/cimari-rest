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

import java.util.List;

@WmiClass(className = "Win32_Battery")
@RegisterForReflection
@Schema(
        name = "Win32_Battery",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-battery)"
)
public record Win32Battery(

        @JsonProperty("DeviceID")
        @Schema(
                description = "Identifier of the battery.",
                nullable = true,
                type = SchemaType.STRING
        )
        String deviceId,

        @JsonProperty("Caption")
        @Schema(
                description = "Short, one-line description of the battery object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Description")
        @Schema(
                description = "Description of the battery.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("Name")
        @Schema(
                description = "Label by which the battery is known.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Status")
        @Schema(
                description = """
                        Current operational status of the battery device.

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

        @JsonProperty("PowerManagementCapabilities")
        @Schema(
                description = """
                        Array of specific power-related capabilities supported by the battery.

                        Possible values:
                        - 0 - Unknown
                        - 1 - Not Supported
                        - 2 - Disabled
                        - 3 - Enabled
                        - 4 - Power Saving Modes Entered Automatically
                        - 5 - Power State Settable
                        - 6 - Power Cycling Supported
                        - 7 - Timed Power On Supported
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> powerManagementCapabilities,

        @JsonProperty("PowerManagementSupported")
        @Schema(
                description = "Indicates whether the battery can be power-managed.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean powerManagementSupported,

        @JsonProperty("BatteryStatus")
        @Schema(
                description = """
                        Status of the battery.

                        Possible values:
                        - 1 - Discharging
                        - 2 - AC present, not charging
                        - 3 - Fully Charged
                        - 4 - Low
                        - 5 - Critical
                        - 6 - Charging
                        - 7 - Charging and High
                        - 8 - Charging and Low
                        - 9 - Charging and Critical
                        - 10 - Undefined
                        - 11 - Partially Charged
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer batteryStatus,

        @JsonProperty("Chemistry")
        @Schema(
                description = """
                        Type of battery chemistry.

                        Possible values:
                        - 1 - Other
                        - 2 - Unknown
                        - 3 - Lead Acid
                        - 4 - Nickel Cadmium
                        - 5 - Nickel Metal Hydride
                        - 6 - Lithium-ion
                        - 7 - Zinc Air
                        - 8 - Lithium Polymer
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer chemistry,

        @JsonProperty("DesignCapacity")
        @Schema(
                description = "Design capacity of the battery in milliwatt-hours.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer designCapacity,

        @JsonProperty("DesignVoltage")
        @Schema(
                description = "Design voltage of the battery in millivolts.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer designVoltage,

        @JsonProperty("EstimatedChargeRemaining")
        @Schema(
                description = "Estimated percentage of full charge remaining.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long estimatedChargeRemaining,

        @JsonProperty("EstimatedRunTime")
        @Schema(
                description = "Estimated remaining runtime of the battery in minutes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long estimatedRunTime

) {
}