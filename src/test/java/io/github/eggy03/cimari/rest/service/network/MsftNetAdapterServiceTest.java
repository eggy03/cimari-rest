/*
 * SPDX-License-Identifier: MIT
 * SPDX-FileCopyrightText: 2025 The ferrumx-windows contributors
 * SPDX-FileCopyrightText: 2026 Cimari contributors
 */
package io.github.eggy03.cimari.rest.service.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetAdapter;
import io.github.eggy03.cimari.rest.exception.MappingException;
import io.github.eggy03.cimari.rest.mapping.network.MsftNetAdapterMapper;
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
class MsftNetAdapterServiceTest {

    private final TerminalResult validTerminalResult = new TerminalResult("{}", "");
    private final TerminalResult invalidTerminalResult = new TerminalResult("invalid json", "");
    private final TerminalResult emptyTerminalResult = new TerminalResult("", "");

    private final MsftNetAdapter expectedEthernet = new MsftNetAdapter(
            "NET1",
            "PCI\\VEN_8086&DEV_15BB&SUBSYS_07B01028&REV_10\\3&11583659&0&FE",
            1L,
            "Ethernet",
            6L,
            "Intel(R) Ethernet Connection I219-V",
            "Ethernet",
            1L,
            false,
            true,
            false,
            "Up",
            "00:1A:2B:3C:4D:5E",
            "1 Gbps",
            1000000000L,
            1000000000L,
            "e1d68x64.sys",
            "12.19.1.37",
            "2023-10-12",
            1500L,
            1L,
            1L,
            1L,
            "802.3",
            "Unspecified"
    );

    private final MsftNetAdapter expectedWifi = new MsftNetAdapter(
            "NET2",
            "PCI\\VEN_14E4&DEV_43A0&SUBSYS_061114E4&REV_03\\4&2AAB3B17&0&00E1",
            2L,
            "Wi-Fi",
            71L,
            "Broadcom 802.11ac Network Adapter",
            "Wi-Fi",
            1L,
            false,
            true,
            false,
            "Up",
            "44:1C:A8:9D:3E:7F",
            "866 Mbps",
            866000000L,
            866000000L,
            "bcmwl63a.sys",
            "7.35.333.0",
            "2022-05-01",
            1500L,
            1L,
            2L,
            2L,
            "802.11",
            "Wireless LAN"
    );


    @Mock
    private TerminalService terminalService;

    @Mock
    private MsftNetAdapterMapper mapper;

    @InjectMocks
    private MsftNetAdapterService service;

    @Test
    void test_get_serviceReturnsMapperResult() {

        when(terminalService.executeQuery(any(StandardCimv2.class), anyLong()))
                .thenReturn(validTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Arrays.asList(expectedEthernet, expectedWifi));

        List<MsftNetAdapter> response = service.get(5L);
        assertThat(response).contains(expectedEthernet, expectedWifi); // Service should return mapper result unchanged

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_ADAPTER, 5L);
        verify(mapper).mapToList(validTerminalResult.result(), MsftNetAdapter.class);
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

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_ADAPTER, 5L);
        verify(mapper).mapToList(invalidTerminalResult.result(), MsftNetAdapter.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void test_get_serviceReturnsEmpty_whenMapperReturnsEmpty() {

        when(terminalService.executeQuery(any(StandardCimv2.class), anyLong()))
                .thenReturn(emptyTerminalResult);

        when(mapper.mapToList(anyString(), any()))
                .thenReturn(Collections.emptyList());

        List<MsftNetAdapter> response = service.get(5L);
        assertThat(response).isEmpty();

        verify(terminalService).executeQuery(StandardCimv2.MSFT_NET_ADAPTER, 5L);
        verify(mapper).mapToList(emptyTerminalResult.result(), MsftNetAdapter.class);
        verifyNoMoreInteractions(terminalService);
        verifyNoMoreInteractions(mapper);
    }
}
