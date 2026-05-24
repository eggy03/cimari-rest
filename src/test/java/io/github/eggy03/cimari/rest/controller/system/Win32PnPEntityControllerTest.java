package io.github.eggy03.cimari.rest.controller.system;

import io.github.eggy03.cimari.rest.entity.system.Win32PnPEntity;
import io.github.eggy03.cimari.rest.service.system.Win32PnPEntityService;
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
class Win32PnPEntityControllerTest {

    private final Win32PnPEntity expectedDevice = new Win32PnPEntity(
            "USB\\VID_045E&PID_07A5\\6&1A2C0F8&0&2",
            "USB\\VID_045E&PID_07A5\\6&1A2C0F8&0&2",
            Collections.singletonList("USB\\VID_045E&PID_07A5&REV_0100"),
            Collections.singletonList("USB\\Class_03&SubClass_01&Prot_02"),
            "USB Composite Device",
            "Generic USB Composite Device",
            "Microsoft",
            true,
            "OK"
    );

    @Mock
    private Win32PnPEntityService service;

    @InjectMocks
    private Win32PnPEntityController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32PnPEntity> expected = Collections.singletonList(expectedDevice);

        when(service.get(15L)).thenReturn(expected);

        List<Win32PnPEntity> response = controller.getAll();

        assertThat(response).containsExactly(expectedDevice);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
