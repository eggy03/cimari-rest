/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.mainboard;

import io.github.eggy03.cimari.rest.entity.mainboard.Win32Bios;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.mainboard.Win32BiosMapper;
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
class Win32BiosServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32Bios expectedBios1 = new Win32Bios(
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

    private final Win32Bios expectedBios2 = new Win32Bios(
            "Phoenix Technologies LTD BIOS",
            "Phoenix SecureCore BIOS",
            "Phoenix Technologies LTD",
            "2023-12-10",
            true,
            "OK",
            "P1.30",
            "en-US",
            "1.30.0",
            false
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32BiosMapper mapper;

    @InjectMocks
    private Win32BiosService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedBios1, expectedBios2));

        List<Win32Bios> response = service.get(5L);
        assertThat(response).contains(expectedBios1, expectedBios2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_BIOS, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32Bios.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_BIOS, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32Bios.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32Bios> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_BIOS, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32Bios.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
