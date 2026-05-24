package io.github.eggy03.cimari.rest.exception.entity;

import io.quarkus.runtime.annotations.RegisterForReflection;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDateTime;

@RegisterForReflection
@Schema(description = "Standard API error response")
public record ErrorResponse (

        @Schema(description = "HTTP Status Code", type = SchemaType.INTEGER)
        int status,

        @Schema(description = "Exception Class Name", type = SchemaType.STRING)
        String error,

        @Schema(description = "Exception Message", type = SchemaType.STRING)
        String message,

        @Schema(description = "Timestamp", implementation = LocalDateTime.class)
        LocalDateTime timeStamp,

        @Schema(description = "Endpoint Path", type = SchemaType.STRING)
        String path
) {}
