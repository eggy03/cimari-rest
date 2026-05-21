package io.github.eggy03.cimari.rest.exception;

import lombok.experimental.StandardException;

/**
 * A general exception wrapper for most of the checked exception arising from {@link io.github.eggy03.cimari.rest.mapping.CommonMappingInterface}
 * methods
 *
 * @since 0.0.1
 */
@StandardException
public class MappingException extends RuntimeException {
}
