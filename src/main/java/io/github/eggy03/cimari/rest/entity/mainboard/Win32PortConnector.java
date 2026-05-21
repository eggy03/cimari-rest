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

import java.util.List;

@WmiClass(className = "Win32_PortConnector")
@RegisterForReflection
@Schema(name = "Win32_PortConnector",
        description = "[Documentation](https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-portconnector)"
)
public record Win32PortConnector(

        @JsonProperty("Tag")
        @Schema(
                description = """
                        Unique identifier of a port connection on the computer system.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String tag,

        @JsonProperty("ExternalReferenceDesignator")
        @Schema(
                description = """
                        External reference designator of the port.

                        External reference designators are identifiers that determine
                        the type and use of the port.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String externalReferenceDesignator,

        @JsonProperty("InternalReferenceDesignator")
        @Schema(
                description = """
                        Internal reference designator of the port.

                        Internal reference designators are specific to the manufacturer,
                        and identify the circuit board location or use of the port.
                        """,
                nullable = true,
                type = SchemaType.STRING
        )
        String internalReferenceDesignator,

        @JsonProperty("PortType")
        @Schema(
                description = """
                        Function of the port.

                        Possible values include:
                        - None (0)
                        - Parallel Port XT/AT Compatible (1)
                        - Parallel Port PS/2 (2)
                        - Parallel Port ECP (3)
                        - Parallel Port EPP (4)
                        - Parallel Port ECP/EPP (5)
                        - Serial Port XT/AT Compatible (6)
                        - Serial Port 16450 Compatible (7)
                        - Serial Port 16550 Compatible (8)
                        - Serial Port 16550A Compatible (9)
                        - SCSI Port (10)
                        - MIDI Port (11)
                        - Joy Stick Port (12)
                        - Keyboard Port (13)
                        - Mouse Port (14)
                        - SSA SCSI (15)
                        - USB (16)
                        - FireWire (IEEE P1394) (17)
                        - PCMCIA Type I (18)
                        - PCMCIA Type II (19)
                        - PCMCIA Type III (20)
                        - Cardbus (21)
                        - Access Bus Port (22)
                        - SCSI II (23)
                        - SCSI Wide (24)
                        - PC-98 (25)
                        - PC-98-Hireso (26)
                        - PC-H98 (27)
                        - Video Port (28)
                        - Audio Port (29)
                        - Modem Port (30)
                        - Network Port (31)
                        - 8251 Compatible (32)
                        - 8251 FIFO Compatible (33)
                        """,
                nullable = true,
                type = SchemaType.INTEGER
        )
        Integer portType,

        @JsonProperty("ConnectorType")
        @Schema(
                description = """
                        Array of physical attributes of the connector used by this port.

                        Refer to the Microsoft documentation provided at the class level
                        for a list of possible values.
                        """,
                nullable = true,
                type = SchemaType.ARRAY
        )
        List<Integer> connectorType

) {}