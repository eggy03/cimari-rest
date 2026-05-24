package io.github.eggy03.cimari.rest.controller.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32DiskDrive;
import io.github.eggy03.cimari.rest.service.storage.Win32DiskDriveService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32DiskDriveControllerTest {

    private final Win32DiskDrive expectedDiskDrive = new Win32DiskDrive(
            "\\\\.\\PHYSICALDRIVE0",
            "Samsung SSD 970 EVO",
            "MZ-V7E1T0",
            BigInteger.valueOf(1000204886016L),
            "2B2QEXM7",
            "S4EVNX0M123456",
            3L,
            "OK",
            "NVMe",
            "PCI\\VEN_144D&DEV_A808&SUBSYS_0A0E144D&REV_01\\4&1A2B3C4D&0&000000",
            Arrays.asList(3, 4),
            Arrays.asList("desc1", "desc2")
    );

    @Mock
    private Win32DiskDriveService service;

    @InjectMocks
    private Win32DiskDriveController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32DiskDrive> expected =
                Collections.singletonList(expectedDiskDrive);

        when(service.get(15L)).thenReturn(expected);

        List<Win32DiskDrive> response = controller.getAll();

        assertThat(response).containsExactly(expectedDiskDrive);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
