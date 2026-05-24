/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.shell.query;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eggy03.cimari.rest.annotation.WmiClass;
import io.github.eggy03.cimari.rest.exception.AnnotationNotFoundException;
import lombok.NonNull;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A utility class that provides helper methods that use Java reflection for aiding in dynamic query construction
 * <p>
 * <b>For internal use only</b>
 *
 * @since 0.0.1
 */
class QueryUtility {

    private QueryUtility() {
        throw new IllegalStateException("Utility Class");
    }

    /**
     * <p>
     * Retrieves a {@link WmiClass} value declared on the specified class, at class level.
     * </p>
     *
     * @param tClass the class having the annotation
     * @param <T>    the type of the class
     * @return the annotation value
     * @throws AnnotationNotFoundException if the class to be inspected does not have the {@link WmiClass} annotation
     * @since 0.0.1
     */
    static @NonNull <T> String getClassNameFromWmiClass(@NonNull Class<T> tClass) {

        WmiClass wmiClass = tClass.getAnnotation(WmiClass.class);

        if (wmiClass == null)
            throw new AnnotationNotFoundException("Missing @WmiClass annotation on: " + tClass.getName());

        return wmiClass.className();
    }

    /**
     * Retrieves all {@link JsonProperty} values declared on the fields of the specified class
     * and returns them as a comma-separated string.
     *
     * <p>Skips fields not having the {@link JsonProperty} annotation</p>
     *
     * <p>The method inspects only fields declared directly within the provided class.
     * Inherited class fields are not included.</p>
     *
     * @param tClass the class whose fields should be inspected
     * @param <T>    the type of the class
     * @return a comma-separated string containing either the "Value" of each
     * {@link JsonProperty} annotation or the field name if the annotation is absent, in alphabetical order
     * @since 0.0.1
     */
    static @NonNull <T> String getPropertiesFromJsonProperty(@NonNull Class<T> tClass) {

        return Arrays.stream(tClass.getDeclaredFields())
                .filter(field -> !field.isSynthetic()) // filter out synthetic fields since JaCoCo creates $jacocoData method during tests which fails the assertions. This behavior is not observed in scenarios where code coverage is not run
                .map(field -> field.getAnnotation(JsonProperty.class))
                .filter(Objects::nonNull)
                .map(JsonProperty::value)
                .filter(Objects::nonNull)
                .sorted()
                .collect(Collectors.joining(", "));
    }
}
