package io.github.eggy03.cimari.rest.mapping.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.mapping.CommonMappingInterface;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Provides a type-safe implementation of {@link CommonMappingInterface}
 * and maps the received JSON strings to objects or lists of {@link Win32CacheMemory}
 *
 * @since 0.1.0
 */
@ApplicationScoped
@RequiredArgsConstructor
public class Win32CacheMemoryMapper implements CommonMappingInterface<Win32CacheMemory> {

    private final @NonNull ObjectMapper mapper;

    @Override
    public @NonNull ObjectMapper getObjectMapper() {
        return mapper;
    }
}
