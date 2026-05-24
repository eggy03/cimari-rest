package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Baseboard;
import io.github.eggy03.cimari.rest.service.mainboard.Win32BaseboardService;
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
class Win32BaseboardControllerTest {

    private final Win32Baseboard expectedBoard = new Win32Baseboard(
            "ASUS",
            "ROG STRIX Z790-E GAMING WIFI",
            "Z790-E",
            "ABC123456789",
            "Rev 1.xx"
    );

    @Mock
    private Win32BaseboardService service;

    @InjectMocks
    private Win32BaseboardController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Baseboard> expected =
                Collections.singletonList(expectedBoard);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Baseboard> response = controller.getAll();

        assertThat(response).containsExactly(expectedBoard);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
