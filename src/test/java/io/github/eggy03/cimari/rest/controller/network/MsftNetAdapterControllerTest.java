package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetAdapter;
import io.github.eggy03.cimari.rest.service.network.MsftNetAdapterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MsftNetAdapterControllerTest {

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

    @Mock
    private MsftNetAdapterService service;

    @InjectMocks
    private MsftNetAdapterController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<MsftNetAdapter> expected =
                Collections.singletonList(expectedEthernet);

        when(service.get(15L)).thenReturn(expected);

        List<MsftNetAdapter> response = controller.getAll();

        assertThat(response).containsExactly(expectedEthernet);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
