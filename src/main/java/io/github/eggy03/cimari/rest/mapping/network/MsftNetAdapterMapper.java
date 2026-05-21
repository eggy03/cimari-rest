/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.mapping.network;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eggy03.cimari.rest.entity.network.MsftNetAdapter;
import io.github.eggy03.cimari.rest.mapping.CommonMappingInterface;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Provides a type-safe implementation of {@link CommonMappingInterface}
 * and maps the received JSON strings to objects or lists of {@link MsftNetAdapter}
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class MsftNetAdapterMapper implements CommonMappingInterface<MsftNetAdapter> {

    private final @NonNull ObjectMapper mapper;

    @Override
    public @NonNull ObjectMapper getObjectMapper() {
        return mapper;
    }
}
