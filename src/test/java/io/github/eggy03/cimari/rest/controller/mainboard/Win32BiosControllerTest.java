package io.github.eggy03.cimari.rest.controller.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Bios;
import io.github.eggy03.cimari.rest.service.mainboard.Win32BiosService;
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
class Win32BiosControllerTest {

    private final Win32Bios expectedBios = new Win32Bios(
            "American Megatrends Inc. BIOS",
            "AMI BIOS",
            "American Megatrends Inc.",
            "2024-03-15",
            true,
            "OK",
            "2.21.1278",
            "en-US",
            "A.10",
            true
    );

    @Mock
    private Win32BiosService service;

    @InjectMocks
    private Win32BiosController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Bios> expected =
                Collections.singletonList(expectedBios);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Bios> response = controller.getAll();

        assertThat(response).containsExactly(expectedBios);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
