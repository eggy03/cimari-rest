package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftDnsClientServerAddress;
import io.github.eggy03.cimari.rest.service.network.MsftDnsClientServerAddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MsftDnsClientServerAddressControllerTest {

    private final MsftDnsClientServerAddress expectedDns = new MsftDnsClientServerAddress(
            1L,
            "Ethernet",
            2,
            Arrays.asList("8.8.8.8", "4.4.4.4")
    );

    @Mock
    private MsftDnsClientServerAddressService service;

    @InjectMocks
    private MsftDnsClientServerAddressController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<MsftDnsClientServerAddress> expected =
                Collections.singletonList(expectedDns);

        when(service.get(15L)).thenReturn(expected);

        List<MsftDnsClientServerAddress> response = controller.getAll();

        assertThat(response).containsExactly(expectedDns);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
