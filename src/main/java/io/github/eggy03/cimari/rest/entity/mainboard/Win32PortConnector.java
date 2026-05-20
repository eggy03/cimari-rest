/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.entity.mainboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;

import java.util.List;

/**
 * Immutable representation of a motherboard port on a Windows system.
 * <p>
 * Fields correspond to properties retrieved from the {@code Win32_PortConnector} WMI class.
 * </p>
 * <p>
 * {@link Win32Baseboard} contains the details of the motherboard this port belongs to.
 *
 * @see <a href="https://learn.microsoft.com/en-us/windows/win32/cimwin32prov/win32-portconnector">Win32_PortConnector Documentation</a>
 * @since 0.1.0
 */
@WmiClass(className = "Win32_PortConnector")
public record Win32PortConnector (
    @JsonProperty("Tag")
    String tag,
    @JsonProperty("ExternalReferenceDesignator")
    String externalReferenceDesignator,
    @JsonProperty("InternalReferenceDesignator")
    String internalReferenceDesignator,
    @JsonProperty("PortType")
    Integer portType,
    @JsonProperty("ConnectorType")
    List< Integer> connectorType
){}