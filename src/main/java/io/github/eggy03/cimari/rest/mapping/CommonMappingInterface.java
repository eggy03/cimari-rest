/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.github.eggy03.cimari.rest.exception.MappingException;
import lombok.NonNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * A common mapping interface for mapping JSON strings to Java objects.
 * <p>
 * Provides default methods to deserialize JSON responses
 * into either a {@link List} of objects or a single {@link Optional} object.
 * The default methods in this interface use Jackson for JSON deserialization.
 * </p>
 *
 * @param <S> the entity type returned by the service implementation
 * @since 0.0.1
 */
public interface CommonMappingInterface<S> {

    /**
     * Configure and return the {@link ObjectMapper} to be used for JSON processing.
     *
     * <p>
     * The default implementation returns a new {@link ObjectMapper} instance with default configuration.
     * </p>
     *
     * <p>
     * Custom implementations may override this method to provide a custom-configured
     * {@link ObjectMapper}.
     * </p>
     *
     * @return the {@link ObjectMapper} to use
     * @since 0.0.1
     */
    default @NonNull ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    /**
     * Deserializes a JSON string into a list of objects of the specified type {@code <S>}.
     * <ul>
     *     <li>If the JSON represents a single object of type {@code <S>},
     *     it is deserialized into an unmodifiable list containing exactly one object of the given type.</li>
     *     <li>If the JSON represents an array of objects of type {@code <S>},
     *     it is deserialized into an unmodifiable list of objects of the given type.</li>
     *     <li>If the JSON is an empty string, returns an empty unmodifiable list.</li>
     * </ul>
     *
     * @param inputJson   the JSON string to parse
     * @param objectClass the class of the objects in the list
     * @return an immutable, non-null list of objects deserialized from JSON.
     * @throws NullPointerException if {@code inputJson} or {@code objectClass} is null
     * @throws MappingException     if {@code inputJson} is parsing fails or deserialization to {@code objectClass} fails
     * @since 0.0.1
     */
    default @NonNull List<S> mapToList(@NonNull String inputJson, @NonNull Class<S> objectClass) {

        String trimmedInputJson = inputJson.trim();
        if (trimmedInputJson.isEmpty())
            return Collections.emptyList();

        try {

            ObjectMapper mapper = getObjectMapper();
            JsonNode inputJsonNode = mapper.readTree(trimmedInputJson);

            if (inputJsonNode.isArray()) {

                TypeFactory typeFactory = mapper.getTypeFactory();
                JavaType listType = typeFactory.constructCollectionType(List.class, objectClass);

                List<S> result = mapper.treeToValue(inputJsonNode, listType);
                return result == null ? Collections.emptyList() : List.copyOf(result);

            } else if (inputJsonNode.isObject()) {

                S result = mapper.treeToValue(inputJsonNode, objectClass);
                return result == null ? Collections.emptyList() : Collections.singletonList(result);

            } else
                throw new MappingException("Expected JSON Array or Object but got: " + inputJsonNode.getNodeType());

        } catch (JsonProcessingException e) {
            throw new MappingException(e);
        }
    }

    /**
     * Deserializes a JSON string into an {@link Optional} of the specified type {@code <S>}.
     *
     * @param inputJson   the JSON string to parse
     * @param objectClass the class of the object to which {@code inputJson} will be deserialized to
     * @return an {@link Optional} of type {@code <S>}
     * @throws NullPointerException if {@code inputJson} or {@code objectClass} is null
     * @throws MappingException     if {@code inputJson} is parsing fails or deserialization to {@code objectClass} fails
     * @since 0.0.1
     */
    default @NonNull Optional<S> mapToObject(@NonNull String inputJson, @NonNull Class<S> objectClass) {

        String trimmedInputJson = inputJson.trim();
        if (trimmedInputJson.isEmpty())
            return Optional.empty();

        try {
            ObjectMapper mapper = getObjectMapper();
            JsonNode inputJsonNode = mapper.readTree(trimmedInputJson);

            if (inputJsonNode.isObject()) {
                S result = mapper.treeToValue(inputJsonNode, objectClass);
                return Optional.ofNullable(result);
            } else
                throw new MappingException("Expected JSON Object but got: " + inputJsonNode.getNodeType());
        } catch (JsonProcessingException e) {
            throw new MappingException(e);
        }
    }
}