/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Battery;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.peripheral.Win32BatteryMapper;
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
class Win32BatteryServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32Battery expectedPrimaryBattery = new Win32Battery(
            "BAT0",
            "Primary Battery",
            "Internal Lithium-Ion Battery",
            "Battery #1",
            "OK",
            Arrays.asList(1, 2, 3),
            true,
            2,
            6,
            50000,
            11000,
            87L,
            120L
    );

    private final Win32Battery expectedSecondaryBattery = new Win32Battery(
            "BAT1",
            "Backup Battery",
            "External Lithium-Polymer Battery",
            "Battery #2",
            "Charging",
            Arrays.asList(1, 2),
            true,
            6,
            7,
            30000,
            7400,
            45L,
            60L
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32BatteryMapper mapper;

    @InjectMocks
    private Win32BatteryService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedPrimaryBattery, expectedSecondaryBattery));

        List<Win32Battery> response = service.get(5L);
        assertThat(response).contains(expectedPrimaryBattery, expectedSecondaryBattery); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_BATTERY, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32Battery.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_BATTERY, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32Battery.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32Battery> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_BATTERY, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32Battery.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}