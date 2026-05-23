package io.github.eggy03.cimari.rest.controller.network;

import io.github.eggy03.cimari.rest.entity.network.MsftNetConnectionProfile;
import io.github.eggy03.cimari.rest.service.network.MsftNetConnectionProfileService;
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
class MsftNetConnectionProfileControllerTest {

    private final MsftNetConnectionProfile expectedEthernetProfile = new MsftNetConnectionProfile(
            1L,
            "Ethernet",
            1L,
            0L,
            4L,
            1L
    );

    @Mock
    private MsftNetConnectionProfileService service;

    @InjectMocks
    private MsftNetConnectionProfileController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<MsftNetConnectionProfile> expected =
                Collections.singletonList(expectedEthernetProfile);

        when(service.get(15L)).thenReturn(expected);

        List<MsftNetConnectionProfile> response = controller.getAll();

        assertThat(response).containsExactly(expectedEthernetProfile);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
