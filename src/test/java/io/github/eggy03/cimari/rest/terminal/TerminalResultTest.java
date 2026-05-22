package io.github.eggy03.cimari.rest.terminal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TerminalResultTest {

    @Test
    @SuppressWarnings("all")
    void testForNullInputsInConstructor_throwsException() {
        NullPointerException ex1 = assertThrows(NullPointerException.class, () -> new TerminalResult(null, ""));
        NullPointerException ex2 = assertThrows(NullPointerException.class, () -> new TerminalResult("", null));
        assertThat(ex1.getMessage()).isEqualTo("result is marked non-null but is null");
        assertThat(ex2.getMessage()).isEqualTo("error is marked non-null but is null");

    }

    @Test
    void testGetterValue() {
        TerminalResult terminalResult = new TerminalResult("a", "b");
        assertThat(terminalResult.result()).isEqualTo("a");
        assertThat(terminalResult.error()).isEqualTo("b");
    }
}
