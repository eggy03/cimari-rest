package io.github.eggy03.cimari.rest.controller.processor;

import io.github.eggy03.cimari.rest.entity.processor.Win32CacheMemory;
import io.github.eggy03.cimari.rest.service.processor.Win32CacheMemoryService;
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
class Win32CacheMemoryControllerTest {

    private final Win32CacheMemory expectedL1Cache = new Win32CacheMemory(
            "CPU0_L1",
            "Instruction",
            3,
            3,
            256L,
            5,
            0,
            5,
            3,
            "OK",
            3
    );

    @Mock
    private Win32CacheMemoryService service;

    @InjectMocks
    private Win32CacheMemoryController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32CacheMemory> expected =
                Collections.singletonList(expectedL1Cache);

        when(service.get(15L)).thenReturn(expected);

        List<Win32CacheMemory> response = controller.getAll();

        assertThat(response).containsExactly(expectedL1Cache);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
