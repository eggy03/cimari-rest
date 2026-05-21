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

import java.math.BigInteger;
import java.util.List;

@WmiClass(className = "Win32_ComputerSystem")
@RegisterForReflection
@Schema(
        name = "Win32_ComputerSystem",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-computersystem)"
)
public record Win32ComputerSystem(

        @JsonProperty("AdminPasswordStatus")
        @Schema(
                description = """
                        System hardware security settings for administrator password status.
                        
                        Possible values:
                        - 0 — Disabled
                        - 1 — Enabled
                        - 2 — Not Implemented
                        - 3 — Unknown
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer adminPasswordStatus,

        @JsonProperty("KeyboardPasswordStatus")
        @Schema(
                description = """
                        System hardware security settings for keyboard password status.
                        
                        Possible values:
                        - 0 — Disabled
                        - 1 — Enabled
                        - 2 — Not Implemented
                        - 3 — Unknown
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer keyboardPasswordStatus,

        @JsonProperty("PowerOnPasswordStatus")
        @Schema(
                description = """
                        System hardware security settings for power-on password status.
                        
                        Possible values:
                        - 0 — Disabled
                        - 1 — Enabled
                        - 2 — Not Implemented
                        - 3 — Unknown
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer powerOnPasswordStatus,

        @JsonProperty("BootupState")
        @Schema(
                description = """
                        System start type.
                        
                        Possible values:
                        - "Normal boot" — Normal boot
                        - "Fail-safe boot" — Safe mode (no network)
                        - "Fail-safe with network boot" — Safe mode with networking
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String bootupState,

        @JsonProperty("BootStatus")
        @Schema(
                description = """
                        Status and additional data fields that identify the boot status.
                        This value comes from the Boot Status member of the System Boot Information structure in the SMBIOS information.
                        
                        Note: BootStatus is platform/firmware dependent and is not supported before Windows 10 and Windows Server 2016
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> bootStatus,

        @JsonProperty("AutomaticResetBootOption")
        @Schema(
                description = "If true, the automatic reset boot option is enabled.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean automaticResetBootOption,

        @JsonProperty("PowerState")
        @Schema(
                description = """
                        Current power state of the computer system.
                        
                        Possible values:
                        - 0 — Unknown
                        - 1 — Full Power
                        - 2 — Power Save - Low Power Mode
                        - 3 — Power Save - Standby
                        - 4 — Power Save - Unknown
                        - 5 — Power Cycle
                        - 6 — Power Off
                        - 7 — Power Save - Warning
                        - 8 — Power Save - Hibernate
                        - 9 — Power Save - Soft Off
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer powerState,

        @JsonProperty("PowerSupplyState")
        @Schema(
                description = """
                        State of the power supply or supplies when last booted.
                        
                        Possible values:
                        - 1 — Other
                        - 2 — Unknown
                        - 3 — Safe
                        - 4 — Warning
                        - 5 — Critical
                        - 6 — Non-recoverable
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer powerSupplyState,

        @JsonProperty("PowerManagementCapabilities")
        @Schema(
                description = """
                        Array of specific power-related capabilities.
                        
                        Possible values:
                        - 0 — Unknown
                        - 1 — Not Supported
                        - 2 — Disabled
                        - 3 — Enabled
                        - 4 — Power Saving Modes Entered Automatically
                        - 5 — Power State Settable
                        - 6 — Power Cycling Supported
                        - 7 — Timed Power On Supported
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> powerManagementCapabilities,

        @JsonProperty("PowerManagementSupported")
        @Schema(
                description = "If true, the device can be power-managed.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean powerManagementSupported,

        @JsonProperty("ResetCapability")
        @Schema(
                description = """
                        If enabled, indicates the unitary computer system can be reset using power and reset buttons.
                        
                        Typical values:
                        - 1 — Other
                        - 2 — Unknown
                        - 3 — Disabled
                        - 4 — Enabled
                        - 5 — Not Implemented
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer resetCapability,

        @JsonProperty("ResetCount")
        @Schema(
                description = """
                        Number of automatic resets since the last reset.
                        A value of -1 indicates the count is unknown.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer resetCount,

        @JsonProperty("ResetLimit")
        @Schema(
                description = """
                        Number of consecutive times a system reset is attempted.
                        A value of -1 indicates the limit is unknown.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer resetLimit,

        @JsonProperty("FrontPanelResetStatus")
        @Schema(
                description = """
                        Hardware security setting for the front-panel reset button.
                        
                        Typical values:
                        - 0 — Disabled
                        - 1 — Enabled
                        - 2 — Not Implemented
                        - 3 — Unknown
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer frontPanelResetStatus,

        @JsonProperty("AutomaticResetCapability")
        @Schema(
                description = "If true, automatic reset capability is available.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean automaticResetCapability,

        @JsonProperty("Name")
        @Schema(
                description = "Key of a CIM_System instance. Name of the computer system.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Caption")
        @Schema(
                description = "Short one-line description of the object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Description")
        @Schema(
                description = "Longer description of the object.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("Manufacturer")
        @Schema(
                description = "Name of the computer manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String manufacturer,

        @JsonProperty("Model")
        @Schema(
                description = "Product name assigned by the manufacturer.",
                nullable = true,
                type = SchemaType.STRING
        )
        String model,

        @JsonProperty("PrimaryOwnerName")
        @Schema(
                description = "Name of the primary owner.",
                nullable = true,
                type = SchemaType.STRING
        )
        String primaryOwnerName,

        @JsonProperty("PrimaryOwnerContact")
        @Schema(
                description = "Contact information for the primary owner.",
                nullable = true,
                type = SchemaType.STRING
        )
        String primaryOwnerContact,

        @JsonProperty("Roles")
        @Schema(
                description = "List of roles the system performs in the environment (editable).",
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> roles,

        @JsonProperty("ChassisSKUNumber")
        @Schema(
                description = "Chassis or enclosure SKU number (from SMBIOS).",
                nullable = true,
                type = SchemaType.STRING
        )
        String chassisSKUNumber,

        @JsonProperty("SystemSKUNumber")
        @Schema(
                description = "SKU/Product ID for the system configuration.",
                nullable = true,
                type = SchemaType.STRING
        )
        String systemSKUNumber,

        @JsonProperty("SystemFamily")
        @Schema(
                description = "Family of the computer (SMBIOS Family field). May be unsupported on older OS versions.",
                nullable = true,
                type = SchemaType.STRING
        )
        String systemFamily,

        @JsonProperty("SystemType")
        @Schema(
                description = """
                        System architecture description
                        
                        Possible values:
                        - "x64-based PC"
                        - "X86-based PC"
                        - "MIPS-based PC"
                        - "Alpha-based PC"
                        - "Power PC"
                        - "SH-x PC"
                        - "StrongARM PC"
                        - "64-bit Intel PC"
                        - "64-bit Alpha PC"
                        - "Unknown"
                        - "X86-Nec98 PC"
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String systemType,

        @JsonProperty("UserName")
        @Schema(
                description = "Currently logged-on user. In Terminal Services scenarios, this is the console user.",
                nullable = true,
                type = SchemaType.STRING
        )
        String userName,

        @JsonProperty("Workgroup")
        @Schema(
                description = "Name of the workgroup or domain (if PartOfDomain==false this is a workgroup name).",
                nullable = true,
                type = SchemaType.STRING
        )
        String workgroup,

        @JsonProperty("OEMStringArray")
        @Schema(
                description = "OEM-defined strings.",
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<String> oemStringArray,

        @JsonProperty("NumberOfProcessors")
        @Schema(
                description = "Number of physical processors installed (enabled).",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long numberOfProcessors,

        @JsonProperty("NumberOfLogicalProcessors")
        @Schema(
                description = "Number of logical processors available (includes hyperthreading logical CPUs).",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long numberOfLogicalProcessors,

        @JsonProperty("TotalPhysicalMemory")
        @Schema(
                description = """
                        Total size of physical memory in bytes.
                        Note: under some circumstances this may not be accurate (BIOS reservation). For accurate module-by-module capacity,
                        query the equivalent method(s) in Win32_PhysicalMemory
                        """,
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger totalPhysicalMemory,

        @JsonProperty("AutomaticManagedPagefile")
        @Schema(
                description = "If true, the system manages the page file automatically.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean automaticManagedPagefile,

        @JsonProperty("InfraredSupported")
        @Schema(
                description = "If true, an infrared (IR) port exists on the computer system.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean infraredSupported,

        @JsonProperty("NetworkServerModeEnabled")
        @Schema(
                description = "If true, network server mode is enabled (system behaves as a server).",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean networkServerModeEnabled,

        @JsonProperty("HypervisorPresent")
        @Schema(
                description = """
                        If true, a hypervisor is present on the system.
                        Note: not supported before Windows 8 / Windows Server 2012 on older OSes.
                        """,
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean hypervisorPresent,

        @JsonProperty("ThermalState")
        @Schema(
                description = """
                        Thermal state of the system when last booted.
                        
                        Possible values:
                        - 1 — Other
                        - 2 — Unknown
                        - 3 — Safe
                        - 4 — Warning
                        - 5 — Critical
                        - 6 — Non-recoverable
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer thermalState,

        @JsonProperty("CurrentTimeZone")
        @Schema(
                description = """
                        Amount of time the system is offset from UTC, in minutes.
                        Example: for UTC+5:30 (Asia/Kolkata) the value is 330.
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer currentTimeZone,

        @JsonProperty("DaylightInEffect")
        @Schema(
                description = "If True, the daylight savings mode is ON.",
                nullable = true,
                type = SchemaType.BOOLEAN
        )
        Boolean daylightInEffect

) {
    // I think im going insane
    public Win32ComputerSystem() {
        this(null, null, null, null,
                null, null, null, null,
                null, null, null,
                null, null, null, null,
                null, null, null, null, null, null,
                null, null, null, null,
                null, null, null, null, null,
                null, null, null,
                null, null, null,
                null, null, null, null
        );
    }
}