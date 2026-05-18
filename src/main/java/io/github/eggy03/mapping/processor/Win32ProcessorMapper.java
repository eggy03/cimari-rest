/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.mapping.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eggy03.entity.Win32Processor;
import io.github.eggy03.mapping.CommonMappingInterface;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Provides a type-safe implementation of {@link CommonMappingInterface}
 * and maps the received JSON strings to objects or lists of {@link Win32Processor}
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32ProcessorMapper implements CommonMappingInterface<Win32Processor> {

    private final @NonNull ObjectMapper mapper;

    @Override
    public @NonNull ObjectMapper configureObjectMapper() {
        return mapper;
    }
}
