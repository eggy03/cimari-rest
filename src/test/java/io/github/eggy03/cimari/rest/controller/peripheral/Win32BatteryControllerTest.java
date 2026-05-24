package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Battery;
import io.github.eggy03.cimari.rest.service.peripheral.Win32BatteryService;
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
class Win32BatteryControllerTest {

    private final Win32Battery expectedPrimaryBattery = new Win32Battery(
            "BAT0",
            "Primary Battery",
            "Internal Lithium-Ion Battery",
            "Battery #1",
            "OK",
            Arrays.asList(1, 2, 3),
            true,
            2,
            6,
            50000,
            11000,
            87L,
            120L
    );

    @Mock
    private Win32BatteryService service;

    @InjectMocks
    private Win32BatteryController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Battery> expected =
                Collections.singletonList(expectedPrimaryBattery);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Battery> response = controller.getAll();

        assertThat(response).containsExactly(expectedPrimaryBattery);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
