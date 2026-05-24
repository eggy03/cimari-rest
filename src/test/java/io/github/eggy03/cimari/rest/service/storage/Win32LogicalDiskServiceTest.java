/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.storage.Win32LogicalDiskMapper;
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
class Win32LogicalDiskServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32LogicalDisk expectedSystemVolume = new Win32LogicalDisk(
            "C:",
            "System Volume",
            3L,
            12L,
            "NTFS",
            BigInteger.valueOf(1000204886016L),
            BigInteger.valueOf(532147200000L),
            false,
            true,
            false,
            "Windows",
            "1A2B-3C4D"
    );

    private final Win32LogicalDisk expectedDataVolume = new Win32LogicalDisk(
            "D:",
            "Data Volume",
            3L,
            12L,
            "NTFS",
            BigInteger.valueOf(2000409772032L),
            BigInteger.valueOf(1240152000000L),
            false,
            true,
            false,
            "Data",
            "5E6F-7G8H"
    );

    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32LogicalDiskMapper mapper;

    @InjectMocks
    private Win32LogicalDiskService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedDataVolume, expectedSystemVolume));

        List<Win32LogicalDisk> response = service.get(5L);
        assertThat(response).contains(expectedDataVolume, expectedSystemVolume); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_LOGICAL_DISK, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32LogicalDisk.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_LOGICAL_DISK, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32LogicalDisk.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32LogicalDisk> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_LOGICAL_DISK, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32LogicalDisk.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
