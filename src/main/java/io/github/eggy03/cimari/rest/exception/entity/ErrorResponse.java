package io.github.eggy03.cimari.rest.exception.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.LocalDateTime;

@RegisterForReflection
public record ErrorResponse (
        int status,
        String error,
        String message,
        LocalDateTime timeStamp,
        String path
) {}
