/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.memory;

import io.github.eggy03.cimari.rest.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.memoery.Win32PhysicalMemoryMapper;
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
class Win32PhysicalMemoryServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32PhysicalMemory expectedMemory1 = new Win32PhysicalMemory(
            "PhysicalMemory1",
            "Corsair Vengeance LPX DDR4",
            "Corsair",
            "CMK16GX4M2B3200C16",
            "DDR4-3200 16GB Module",
            "CMK16GX4M2B3200C16",
            8,
            "BANK 0",
            BigInteger.valueOf(16L * 1024 * 1024 * 1024),
            64,
            3200L,
            3200L,
            "DIMM_A1",
            "ABC123456789"
    );

    private final Win32PhysicalMemory expectedMemory2 = new Win32PhysicalMemory(
            "PhysicalMemory2",
            "G.Skill Trident Z5 DDR5",
            "G.Skill",
            "F5-6000J3238F16GX2-TZ5RK",
            "DDR5-6000 16GB Module",
            "F5-6000J3238F16GX2-TZ5RK",
            8,
            "BANK 1",
            BigInteger.valueOf(16L * 1024 * 1024 * 1024),
            64,
            6000L,
            6000L,
            "DIMM_B1",
            "XYZ987654321"
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32PhysicalMemoryMapper mapper;

    @InjectMocks
    private Win32PhysicalMemoryService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedMemory1, expectedMemory2));

        List<Win32PhysicalMemory> response = service.get(5L);
        assertThat(response).contains(expectedMemory1, expectedMemory2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_PHYSICAL_MEMORY, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32PhysicalMemory.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_PHYSICAL_MEMORY, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32PhysicalMemory.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32PhysicalMemory> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_PHYSICAL_MEMORY, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32PhysicalMemory.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
