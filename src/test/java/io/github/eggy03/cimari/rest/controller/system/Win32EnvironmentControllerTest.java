package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32Environment;
import io.github.eggy03.cimari.rest.service.system.Win32EnvironmentService;
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
class Win32EnvironmentControllerTest {

    private final Win32Environment sysVar = new Win32Environment(
            "PATH",
            true,
            "C:\\Windows\\System32"
    );

    @Mock
    private Win32EnvironmentService service;

    @InjectMocks
    private Win32EnvironmentController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Environment> expected =
                Collections.singletonList(sysVar);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Environment> response = controller.getAll();

        assertThat(response).containsExactly(sysVar);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
