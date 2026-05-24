package io.github.eggy03.cimari.rest.controller.memory;

import io.github.eggy03.cimari.rest.entity.memory.Win32PhysicalMemory;
import io.github.eggy03.cimari.rest.service.memory.Win32PhysicalMemoryService;
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
class Win32PhysicalMemoryControllerTest {

    private final Win32PhysicalMemory expectedMemory = new Win32PhysicalMemory(
            "PhysicalMemory1",
            "Corsair Vengeance LPX DDR4",
            "Corsair",
            "CMK16GX4M2B3200C16",
            "DDR4-3200 16GB Module",
            "CMK16GX4M2B3200C16",
            8,
            "BANK 0",
            BigInteger.valueOf(16L * 1024 * 1024 * 1024),
            64,
            3200L,
            3200L,
            "DIMM_A1",
            "ABC123456789"
    );

    @Mock
    private Win32PhysicalMemoryService service;

    @InjectMocks
    private Win32PhysicalMemoryController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32PhysicalMemory> expected =
                Collections.singletonList(expectedMemory);

        when(service.get(15L)).thenReturn(expected);

        List<Win32PhysicalMemory> response = controller.getAll();

        assertThat(response).containsExactly(expectedMemory);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
