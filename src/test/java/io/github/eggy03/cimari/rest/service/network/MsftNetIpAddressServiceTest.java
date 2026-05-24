/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetIpAddress;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.network.MsftNetIpAddressMapper;
import io.github.eggy03.cimari.rest.shell.query.StandardCimv2;
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
class MsftNetIpAddressServiceTest {

    private final MsftNetIpAddress.Datetime lifetime = new MsftNetIpAddress.Datetime(9999L, 0L, 0L, 0L);

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final MsftNetIpAddress expectedIPv4Address = new MsftNetIpAddress(
            1L,
            "Ethernet",
            2L,
            "192.168.1.10",
            "192.168.1.10",
            null,
            1,
            1L,
            2L,
            24L,
            lifetime,
            lifetime
    );

    private final MsftNetIpAddress expectedIPv6Address = new MsftNetIpAddress(
            2L,
            "Wi-Fi",
            23L,
            "fe80::1a2b:3c4d:5e6f:7a8b",
            null,
            "fe80::1a2b:3c4d:5e6f:7a8b",
            2,
            3L,
            3L,
            64L,
            lifetime,
            lifetime
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private MsftNetIpAddressMapper mapper;

    @InjectMocks
    private MsftNetIpAddressService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(StandardCimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedIPv4Address, expectedIPv6Address));

        List<MsftNetIpAddress> response = service.get(5L);
        assertThat(response).contains(expectedIPv4Address, expectedIPv6Address); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_IP_ADDRESS, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), MsftNetIpAddress.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_mapperThrows_servicePropagatesException() {

        when(terminalService.executeQuery(any(StandardCimv2.class), anyLong()))
                .thenReturn(invalidTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenThrow(MappingException.class);

        assertThrows(MappingException.class, () -> service.get(5L));

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_IP_ADDRESS, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), MsftNetIpAddress.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(StandardCimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<MsftNetIpAddress> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_IP_ADDRESS, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), MsftNetIpAddress.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
