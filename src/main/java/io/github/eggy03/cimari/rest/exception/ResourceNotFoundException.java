/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2026 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.exception;

import lombok.experimental.StandardException;

/**
 * Used to indicate that a critical resource could not be resolved, without which, it is impossible to
 * proceed with further operations.
 * <p>Mapped by {@link io.github.eggy03.cimari.rest.exception.mapper.GenericExceptionMapper}</p>
 * @since 0.0.1
 */
@StandardException
public class ResourceNotFoundException extends RuntimeException {
}
