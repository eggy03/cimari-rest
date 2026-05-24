package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32Printer;
import io.github.eggy03.cimari.rest.service.peripheral.Win32PrinterService;
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
class Win32PrinterControllerTest {

    private final Win32Printer expectedPrinter = new Win32Printer(
            "PRN1",
            "HP LaserJet Pro M404dn",
            "USBPRINT\\Hewlett-PackardHP_LaB1A1\\7&1111A11&0&USB001",
            Arrays.asList(1, 2, 3),
            Arrays.asList("Duplex", "Color", "Staple"),
            1200L,
            1200L,
            Arrays.asList(1, 5, 9),
            Arrays.asList("A4", "Letter", "Legal"),
            0,
            "RAW",
            "winprint",
            "HP Universal Printing PCL 6",
            true,
            "HP_LaserJet_Office",
            true,
            false
    );

    @Mock
    private Win32PrinterService service;

    @InjectMocks
    private Win32PrinterController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32Printer> expected =
                Collections.singletonList(expectedPrinter);

        when(service.get(15L)).thenReturn(expected);

        List<Win32Printer> response = controller.getAll();

        assertThat(response).containsExactly(expectedPrinter);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
