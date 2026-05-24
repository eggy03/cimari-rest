/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.system;

import io.github.eggy03.cimari.rest.entity.system.Win32Process;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.system.Win32ProcessMapper;
import io.github.eggy03.cimari.rest.shell.query.Cimv2;
import io.github.eggy03.cimari.rest.terminal.TerminalResult;
import io.github.eggy03.cimari.rest.terminal.TerminalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
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
class Win32ProcessServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32Process expectedProcess1 = new Win32Process(
            1234L,
            1L,
            "explorer.exe",
            "Windows Explorer",
            "Manages the Windows shell",
            "C:\\Windows\\explorer.exe",
            1,
            "0xABC",
            500L,
            8L,
            35L,
            new BigInteger("120000000"),
            new BigInteger("80000000"),
            new BigInteger("52428800"),
            new BigInteger("67108864"),
            new BigInteger("33554432"),
            30000L,
            40000L,
            new BigInteger("268435456"),
            new BigInteger("536870912"),
            "20251103101530.000000+330",
            null
    );

    private final Win32Process expectedProcess2 = new Win32Process(
            5678L,
            1L,
            "svchost.exe",
            "Service Host",
            "Hosts Windows services",
            "C:\\Windows\\System32\\svchost.exe",
            1,
            "0xDEF",
            200L,
            8L,
            10L,
            new BigInteger("60000000"),
            new BigInteger("40000000"),
            new BigInteger("26214400"),
            new BigInteger("31457280"),
            new BigInteger("16777216"),
            15000L,
            20000L,
            new BigInteger("134217728"),
            new BigInteger("268435456"),
            "20251103102000.000000+330",
            null
    );

    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32ProcessMapper mapper;

    @InjectMocks
    private Win32ProcessService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedProcess1, expectedProcess2));

        List<Win32Process> response = service.get(5L);
        assertThat(response).contains(expectedProcess1, expectedProcess2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_PROCESS, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32Process.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_PROCESS, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32Process.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32Process> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_PROCESS, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32Process.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
