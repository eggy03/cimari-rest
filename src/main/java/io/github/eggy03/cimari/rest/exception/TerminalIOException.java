/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.exception;

import io.github.eggy03.cimari.rest.terminal.TerminalService;
import lombok.experimental.StandardException;

/**
 * A generic wrapper for all IO exceptions occurring from {@link TerminalService}
 *
 * @since 0.0.1
 */
@StandardException
public class TerminalIOException extends RuntimeException {
}