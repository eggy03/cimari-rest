package io.github.eggy03.cimari.rest.controller.processor;

import io.github.eggy03.cimari.rest.entity.processor.Win32Processor;
import io.github.eggy03.cimari.rest.service.processor.Win32ProcessorService;
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
class Win32ProcessorControllerTest {

    private final Win32Processor expectedProcessor = new Win32Processor(
            "CPU0",
            "Intel(R) Core(TM) i9-13900K",
            24,
            24,
            32,
            32,
            "GenuineIntel",
            64,
            2048,
            36864,
            5300,
            100,
            "LGA1700",
            "Model 151 Stepping 2",
            "Intel64 Family 6 Model 151 Stepping 2",
            6,
            "2",
            true,
            "BFEBFBFF000B0671",
            9
    );

    @Mock
    private Win32ProcessorService service;

    @InjectMocks
    private Win32ProcessorController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Processor> expected =
                Collections.singletonList(expectedProcessor);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Processor> response = controller.getAll();

        assertThat(response).containsExactly(expectedProcessor);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
