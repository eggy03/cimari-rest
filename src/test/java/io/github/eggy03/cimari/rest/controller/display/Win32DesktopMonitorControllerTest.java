package io.github.eggy03.cimari.rest.controller.display;

import io.github.eggy03.cimari.rest.entity.display.Win32DesktopMonitor;
import io.github.eggy03.cimari.rest.service.display.Win32DesktopMonitorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32DesktopMonitorControllerTest {

    private final Win32DesktopMonitor expectedMonitor = new Win32DesktopMonitor(
            "MON1",
            "Dell U2720Q",
            "DISPLAY\\\\DELA0B1\\\\5&12345&0&UID4352",
            "OK",
            "Dell Inc.",
            "LCD",
            96,
            96
    );

    @Mock
    private Win32DesktopMonitorService service;

    @InjectMocks
    private Win32DesktopMonitorController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32DesktopMonitor> expected =
                Collections.singletonList(expectedMonitor);

        when(service.get(15L)).thenReturn(expected);

        List<Win32DesktopMonitor> response = controller.getAll();

        assertThat(response).containsExactly(expectedMonitor);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
