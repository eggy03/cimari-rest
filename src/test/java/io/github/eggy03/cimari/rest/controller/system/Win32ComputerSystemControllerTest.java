package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32ComputerSystem;
import io.github.eggy03.cimari.rest.service.system.Win32ComputerSystemService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32ComputerSystemControllerTest {

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
    private Win32ComputerSystemService service;

    @InjectMocks
    private Win32ComputerSystemController controller;

    @Test
    void test_get_returnsServiceResult() {

        when(service.get(15L)).thenReturn(Optional.of(expectedComputerSystem));

        Win32ComputerSystem response = controller.get();

        assertThat(response).isEqualTo(expectedComputerSystem);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }

    @Test
    void test_get_serviceReturnsOptionalEmpty_returnsObjectWithNullFields() {

        when(service.get(15)).thenReturn(Optional.empty());

        Win32ComputerSystem response = controller.get();

        assertThat(response).isEqualTo(new Win32ComputerSystem());

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
