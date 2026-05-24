package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32Process;
import io.github.eggy03.cimari.rest.service.system.Win32ProcessService;
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
class Win32ProcessControllerTest {

    private final Win32Process expectedProcess = new Win32Process(
            1234L,
            1L,
            "explorer.exe",
            "Windows Explorer",
            "Manages the Windows shell",
            "C:\\Windows\\explorer.exe",
            1,
            "0xABC",
            500L,
            8L,
            35L,
            new BigInteger("120000000"),
            new BigInteger("80000000"),
            new BigInteger("52428800"),
            new BigInteger("67108864"),
            new BigInteger("33554432"),
            30000L,
            40000L,
            new BigInteger("268435456"),
            new BigInteger("536870912"),
            "20251103101530.000000+330",
            null
    );

    @Mock
    private Win32ProcessService service;

    @InjectMocks
    private Win32ProcessController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Process> expected = Collections.singletonList(expectedProcess);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Process> response = controller.getAll();

        assertThat(response).containsExactly(expectedProcess);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
