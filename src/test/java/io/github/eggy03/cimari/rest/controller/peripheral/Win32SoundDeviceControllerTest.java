package io.github.eggy03.cimari.rest.controller.peripheral;

import io.github.eggy03.cimari.rest.entity.peripheral.Win32SoundDevice;
import io.github.eggy03.cimari.rest.service.peripheral.Win32SoundDeviceService;
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
class Win32SoundDeviceControllerTest {

    private final Win32SoundDevice expectedDevice = new Win32SoundDevice(
            "AUDIO\\0001",
            "Realtek High Definition Audio",
            "HDAUDIO\\FUNC_01&VEN_10EC&DEV_0256&SUBSYS_10431A00&REV_1000",
            "Realtek Semiconductor Corp.",
            "OK",
            3
    );

    @Mock
    private Win32SoundDeviceService service;

    @InjectMocks
    private Win32SoundDeviceController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32SoundDevice> expected =
                Collections.singletonList(expectedDevice);

        when(service.get(15L)).thenReturn(expected);

        List<Win32SoundDevice> response = controller.getAll();

        assertThat(response).containsExactly(expectedDevice);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
