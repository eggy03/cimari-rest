/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32DiskDrive;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.storage.Win32DiskDriveMapper;
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
class Win32DiskDriveServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32DiskDrive expectedDiskDrive1 = new Win32DiskDrive(
            "\\\\.\\PHYSICALDRIVE0",
            "Samsung SSD 970 EVO",
            "MZ-V7E1T0",
            BigInteger.valueOf(1000204886016L),
            "2B2QEXM7",
            "S4EVNX0M123456",
            3L,
            "OK",
            "NVMe",
            "PCI\\VEN_144D&DEV_A808&SUBSYS_0A0E144D&REV_01\\4&1A2B3C4D&0&000000",
            Arrays.asList(3, 4),
            Arrays.asList("desc1", "desc2")
    );

    private final Win32DiskDrive expectedDiskDrive2 = new Win32DiskDrive(
            "\\\\.\\PHYSICALDRIVE1",
            "Seagate BarraCuda 2TB",
            "ST2000DM008",
            BigInteger.valueOf(2000398934016L),
            "CC26",
            "ZFL123ABC456",
            2L,
            "OK",
            "SATA",
            "PCI\\VEN_8086&DEV_A102&SUBSYS_85C41043&REV_31\\3&11583659&0&FA",
            Arrays.asList(3, 4),
            Arrays.asList("desc1", "desc2")
    );

    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32DiskDriveMapper mapper;

    @InjectMocks
    private Win32DiskDriveService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedDiskDrive1, expectedDiskDrive2));

        List<Win32DiskDrive> response = service.get(5L);
        assertThat(response).contains(expectedDiskDrive1, expectedDiskDrive2); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_DISK_DRIVE, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), Win32DiskDrive.class);
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

        verify(terminalService).executeQuery(Cimv2.WIN32_DISK_DRIVE, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), Win32DiskDrive.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<Win32DiskDrive> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_DISK_DRIVE, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), Win32DiskDrive.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}