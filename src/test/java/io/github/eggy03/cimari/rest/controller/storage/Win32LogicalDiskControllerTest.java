package io.github.eggy03.cimari.rest.controller.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32LogicalDisk;
import io.github.eggy03.cimari.rest.service.storage.Win32LogicalDiskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class Win32LogicalDiskControllerTest {

    private final Win32LogicalDisk expectedSystemVolume = new Win32LogicalDisk(
            "C:",
            "System Volume",
            3L,
            12L,
            "NTFS",
            BigInteger.valueOf(1000204886016L),
            BigInteger.valueOf(532147200000L),
            false,
            true,
            false,
            "Windows",
            "1A2B-3C4D"
    );

    @Mock
    private Win32LogicalDiskService service;

    @InjectMocks
    private Win32LogicalDiskController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32LogicalDisk> expected =
                Collections.singletonList(expectedSystemVolume);

        when(service.get(15L)).thenReturn(expected);

        List<Win32LogicalDisk> response = controller.getAll();

        assertThat(response).containsExactly(expectedSystemVolume);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
