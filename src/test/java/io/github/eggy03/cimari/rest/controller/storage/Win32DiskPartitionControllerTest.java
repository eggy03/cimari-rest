package io.github.eggy03.cimari.rest.controller.storage;

import io.github.eggy03.cimari.rest.entity.storage.Win32DiskPartition;
import io.github.eggy03.cimari.rest.service.storage.Win32DiskPartitionService;
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
class Win32DiskPartitionControllerTest {

    private final Win32DiskPartition expectedSystemPartition = new Win32DiskPartition(
            "Disk0\\Partition1",
            "System Reserved",
            "EFI System Partition",
            BigInteger.valueOf(512L),
            BigInteger.valueOf(131072L),
            true,
            true,
            true,
            0L,
            BigInteger.valueOf(67108864L),
            "EFI"
    );

    @Mock
    private Win32DiskPartitionService service;

    @InjectMocks
    private Win32DiskPartitionController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32DiskPartition> expected =
                Collections.singletonList(expectedSystemPartition);

        when(service.get(15L)).thenReturn(expected);

        List<Win32DiskPartition> response = controller.getAll();

        assertThat(response).containsExactly(expectedSystemPartition);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
