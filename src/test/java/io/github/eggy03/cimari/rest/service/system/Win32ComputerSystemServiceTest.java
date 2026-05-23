/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.system;

import io.github.eggy03.cimari.rest.entity.system.Win32ComputerSystem;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.system.Win32ComputerSystemMapper;
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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32ComputerSystemServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final Win32ComputerSystem expectedComputerSystem = new Win32ComputerSystem(
            3,
            3,
            3,
            "Normal boot",
            Arrays.asList(0, 1),
            true,
            1,
            3,
            Arrays.asList(1, 2, 3),
            true,
            4,
            1,
            5,
            2,
            true,
            "DESKTOP-12345",
            "Workstation PC",
            "High-end office workstation",
            "ASUSTeK COMPUTER INC.",
            "ProArt B760-Creator D4",
            "User",
            "user@example.com",
            Arrays.asList("LM_Workstation", "LM_Server"),
            "PROD-1234",
            "Default String",
            "Desktop",
            "x64-based PC",
            "DESKTOP-12345\\User",
            "WORKGROUP",
            Collections.singletonList("Default String"),
            1L,
            20L,
            BigInteger.valueOf(17122615296L),
            true,
            false,
            true,
            false,
            3,
            330,
            true
    );

    @Mock
    private TerminalService terminalService;

    @Mock
    private Win32ComputerSystemMapper mapper;

    @InjectMocks
    private Win32ComputerSystemService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToObject(anyString(), any()))
                .thenReturn(Optional.of(expectedComputerSystem));

        Optional<Win32ComputerSystem> response = service.get(5L);
        assertThat(response).contains(expectedComputerSystem); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(Cimv2.WIN32_COMPUTER_SYSTEM, 5L);
        verify(mapper).mapToObject(validTerminalResult.result(), Win32ComputerSystem.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_mapperThrows_servicePropagatesException() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(invalidTerminalResult);

        when(mapper.mapToObject(anyString(), any()))
                .thenThrow(MappingException.class);

        assertThrows(MappingException.class, () -> service.get(5L));

        verify(terminalService).executeQuery(Cimv2.WIN32_COMPUTER_SYSTEM, 5L);
        verify(mapper).mapToObject(invalidTerminalResult.result(), Win32ComputerSystem.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(Cimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToObject(anyString(), any()))
                .thenReturn(Optional.empty());

        Optional<Win32ComputerSystem> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(Cimv2.WIN32_COMPUTER_SYSTEM, 5L);
        verify(mapper).mapToObject(emptyTerminalResult.result(), Win32ComputerSystem.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
