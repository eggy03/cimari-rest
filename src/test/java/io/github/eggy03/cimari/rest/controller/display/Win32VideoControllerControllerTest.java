package io.github.eggy03.cimari.rest.controller.display;

import io.github.eggy03.cimari.rest.entity.display.Win32VideoController;
import io.github.eggy03.cimari.rest.service.display.Win32VideoControllerService;
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
class Win32VideoControllerControllerTest {

    private final Win32VideoController expectedGpu = new Win32VideoController(
            "GPU1",
            "NVIDIA GeForce RTX 4090",
            "PCI\\VEN_10DE&DEV_2684&SUBSYS_409010DE&REV_A1",
            32,
            3840,
            2160,
            144,
            240,
            60,
            "Integrated RAMDAC",
            24000000000L,
            "2024-09-12",
            "552.22",
            "AD102"
    );

    @Mock
    private Win32VideoControllerService service;

    @InjectMocks
    private Win32VideoControllerController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32VideoController> expected =
                Collections.singletonList(expectedGpu);

        when(service.get(15L)).thenReturn(expected);

        List<Win32VideoController> response = controller.getAll();

        assertThat(response).containsExactly(expectedGpu);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
