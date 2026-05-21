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

@WmiClass(className = "Win32_Process")
@RegisterForReflection
@Schema(
        name = "Win32_Process",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-process)"
)
public record Win32Process(

        @JsonProperty("ProcessId")
        @Schema(
                description = "Unique identifier of the process.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long processId,

        @JsonProperty("SessionId")
        @Schema(
                description = "Identifier of the session under which this process is running.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long sessionId,

        @JsonProperty("Name")
        @Schema(
                description = "Name of the executable file responsible for this process.",
                nullable = true,
                type = SchemaType.STRING
        )
        String name,

        @JsonProperty("Caption")
        @Schema(
                description = "Short one-line description of the process.",
                nullable = true,
                type = SchemaType.STRING
        )
        String caption,

        @JsonProperty("Description")
        @Schema(
                description = "Full description of the process.",
                nullable = true,
                type = SchemaType.STRING
        )
        String description,

        @JsonProperty("ExecutablePath")
        @Schema(
                description = "Full path to the executable file of the process.",
                nullable = true,
                type = SchemaType.STRING
        )
        String executablePath,

        @JsonProperty("ExecutionState")
        @Schema(
                description = """
                        Current execution state of the process.
                        
                        Possible values:
                        - 0 — Unknown
                        - 1 — Other
                        - 2 — Ready
                        - 3 — Running
                        - 4 — Blocked
                        - 5 — Suspended Blocked
                        - 6 — Suspended Ready
                        - 7 — Terminated
                        - 8 — Stopped
                        - 9 — Growing
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer executionState,

        @JsonProperty("Handle")
        @Schema(
                description = "Handle of the process (string representation of ProcessId).",
                nullable = true,
                type = SchemaType.STRING
        )
        String handle,

        @JsonProperty("HandleCount")
        @Schema(
                description = "Number of handles currently open by the process.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long handleCount,

        @JsonProperty("Priority")
        @Schema(
                description = """
                        Scheduling priority of the process.
                        
                        Possible values:
                        - 0 (lowest) to 31 (highest)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long priority,

        @JsonProperty("ThreadCount")
        @Schema(
                description = "Number of active threads in the process.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long threadCount,

        @JsonProperty("KernelModeTime")
        @Schema(
                description = "Time spent by the process in kernel mode, in milliseconds.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger kernelModeTime,

        @JsonProperty("UserModeTime")
        @Schema(
                description = "Time spent by the process in user mode, in milliseconds.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger userModeTime,

        @JsonProperty("WorkingSetSize")
        @Schema(
                description = "Current working set size used by the process, in bytes.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger workingSetSize,

        @JsonProperty("PeakWorkingSetSize")
        @Schema(
                description = "Peak working set size of the process, in kilobytes.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger peakWorkingSetSize,

        @JsonProperty("PrivatePageCount")
        @Schema(
                description = "Current number of private memory pages used by the process.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger privatePageCount,

        @JsonProperty("PageFileUsage")
        @Schema(
                description = "Current amount of page file usage, in kilobytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long pageFileUsage,

        @JsonProperty("PeakPageFileUsage")
        @Schema(
                description = "Peak page file usage, in kilobytes.",
                nullable = true,
                type = SchemaType.INTEGER
        )
        Long peakPageFileUsage,

        @JsonProperty("VirtualSize")
        @Schema(
                description = "Current virtual address space used by the process, in bytes.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger virtualSize,

        @JsonProperty("PeakVirtualSize")
        @Schema(
                description = "Peak virtual address space used by the process, in bytes.",
                nullable = true,
                type = SchemaType.NUMBER
        )
        BigInteger peakVirtualSize,

        @JsonProperty("CreationDate")
        @Schema(
                description = "Date and time when the process was created.",
                nullable = true,
                type = SchemaType.STRING
        )
        String creationDate,

        @JsonProperty("TerminationDate")
        @Schema(
                description = "Date and time when the process was terminated, if available.",
                nullable = true,
                type = SchemaType.STRING
        )
        String terminationDate

) {
}