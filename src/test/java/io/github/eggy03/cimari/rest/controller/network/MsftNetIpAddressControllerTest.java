package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetIpAddress;
import io.github.eggy03.cimari.rest.service.network.MsftNetIpAddressService;
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
class MsftNetIpAddressControllerTest {

    private final MsftNetIpAddress.Datetime lifetime = new MsftNetIpAddress.Datetime(9999L, 0L, 0L, 0L);

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

    @Mock
    private MsftNetIpAddressService service;

    @InjectMocks
    private MsftNetIpAddressController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<MsftNetIpAddress> expected =
                Collections.singletonList(expectedIPv4Address);

        when(service.get(15L)).thenReturn(expected);

        List<MsftNetIpAddress> response = controller.getAll();

        assertThat(response).containsExactly(expectedIPv4Address);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
