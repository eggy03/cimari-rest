package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32OperatingSystem;
import io.github.eggy03.cimari.rest.service.system.Win32OperatingSystemService;
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
class Win32OperatingSystemControllerTest {

    private final Win32OperatingSystem expectedOs = new Win32OperatingSystem(
            "Microsoft Windows 11 Pro|C:\\WINDOWS|\\Device\\Harddisk0\\Partition4",
            "Microsoft Windows 11 Pro",
            "20240101000000.000000+330",
            "DESKTOP-12345",
            "20241102123000.000000+330",
            "20251103180000.000000+330",
            false,
            1,
            "10.0.22631",
            "\\Device\\HarddiskVolume3",
            "22631",
            "Multiprocessor Free",
            "Microsoft Corporation",
            "64-bit",
            Collections.singletonList("en-US"),
            false,
            true,
            "User",
            "00330-80000-00000-AA123",
            0,
            0,
            "C:\\WINDOWS\\system32",
            "C:",
            "C:\\WINDOWS"
    );

    @Mock
    private Win32OperatingSystemService service;

    @InjectMocks
    private Win32OperatingSystemController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32OperatingSystem> expected = Collections.singletonList(expectedOs);

        when(service.get(15L)).thenReturn(expected);

        List<Win32OperatingSystem> response = controller.getAll();

        assertThat(response).containsExactly(expectedOs);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
