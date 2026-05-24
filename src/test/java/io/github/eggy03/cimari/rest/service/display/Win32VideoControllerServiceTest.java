/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.display;

import io.github.eggy03.cimari.rest.entity.display.Win32VideoController;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.display.Win32VideoControllerMapper;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32VideoControllerServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32VideoController expectedGpu1 = new Win32VideoController(
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

    private final Win32VideoController expectedGpu2 = new Win32VideoController(
            "GPU2",
            "AMD Radeon RX 7900 XTX",
            "PCI\\VEN_1002&DEV_744C&SUBSYS_79001002&REV_C8",
            32,
            2560,
            1440,
            165,
            240,
            60,
            "Internal DAC",
            20000000000L,
            "2024-07-05",
            "24.7.1",
            "Navi 31 XTX"
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32VideoControllerMapper mapper;

    @InjectMocks
    private Win32VideoControllerService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedGpu1, expectedGpu2));

        List<Win32VideoController> response = service.get(5L);
        assertThat(response).contains(expectedGpu1, expectedGpu2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_VIDEO_CONTROLLER, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32VideoController.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_mapperThrows_servicePropagatesException() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(invalidTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenThrow(MappingException.class);

        assertThrows(MappingException.class, () -> service.get(5L));

        verify(terminalService).executeQuery(Cimv2.WIN32_VIDEO_CONTROLLER, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32VideoController.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32VideoController> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_VIDEO_CONTROLLER, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32VideoController.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

}
