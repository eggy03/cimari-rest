/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Printer;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.peripheral.Win32PrinterMapper;
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
class Win32PrinterServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32Printer expectedPrinter1 = new Win32Printer(
            "PRN1",
            "HP LaserJet Pro M404dn",
            "USBPRINT\\Hewlett-PackardHP_LaB1A1\\7&1111A11&0&USB001",
            Arrays.asList(1, 2, 3),
            Arrays.asList("Duplex", "Color", "Staple"),
            1200L,
            1200L,
            Arrays.asList(1, 5, 9),
            Arrays.asList("A4", "Letter", "Legal"),
            0,
            "RAW",
            "winprint",
            "HP Universal Printing PCL 6",
            true,
            "HP_LaserJet_Office",
            true,
            false
    );

    private final Win32Printer expectedPrinter2 = new Win32Printer(
            "PRN2",
            "Canon PIXMA G3020",
            "USBPRINT\\CanonG3020_SERIES\\7&2222B22&0&USB002",
            Arrays.asList(2, 4),
            Arrays.asList("Color", "Scan"),
            600L,
            600L,
            Arrays.asList(1, 9),
            Arrays.asList("A4", "Legal"),
            1,
            "RAW",
            "winprint",
            "Canon G3000 series Printer",
            false,
            null,
            true,
            false
    );

    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32PrinterMapper mapper;

    @InjectMocks
    private Win32PrinterService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedPrinter1, expectedPrinter2));

        List<Win32Printer> response = service.get(5L);
        assertThat(response).contains(expectedPrinter1, expectedPrinter2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_PRINTER, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32Printer.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_PRINTER, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32Printer.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32Printer> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_PRINTER, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32Printer.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
