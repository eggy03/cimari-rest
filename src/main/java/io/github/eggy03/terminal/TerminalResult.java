package io.github.eggy03.terminal;

import lombok.NonNull;

/**
 * Represents the result of a command or script executed via {@link TerminalService}.
 * <p>
 * This class encapsulates both the standard output (stdout) and standard error (stderr)
 * produced during execution.
 * </p>
 *
 * @since 0.1.0
 */
public record TerminalResult(@NonNull String result, @NonNull String error) {

}