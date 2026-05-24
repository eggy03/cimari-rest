package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32PortConnector;
import io.github.eggy03.cimari.rest.service.mainboard.Win32PortConnectorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32PortConnectorControllerTest {

    private final Win32PortConnector expectedPort = new Win32PortConnector(
            "PortConnector1",
            "USB3_0",
            "JUSB1",
            1,
            Arrays.asList(1, 2, 3)
    );

    @Mock
    private Win32PortConnectorService service;

    @InjectMocks
    private Win32PortConnectorController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32PortConnector> expected =
                Collections.singletonList(expectedPort);

        when(service.get(15L)).thenReturn(expected);

        List<Win32PortConnector> response = controller.getAll();

        assertThat(response).containsExactly(expectedPort);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
