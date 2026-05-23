package io.github.eggy03.cimari.rest.controller.user;

import io.github.eggy03.cimari.rest.entity.user.Win32UserAccount;
import io.github.eggy03.cimari.rest.service.user.Win32UserAccountService;
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
class Win32UserAccountControllerTest {

    private final Win32UserAccount expectedUser = new Win32UserAccount(
            "S-1-5-21-1234567890-1001",
            1,
            512L,
            "User1",
            "Local user account",
            "WORKGROUP",
            "Egg-03",
            false,
            true,
            false,
            true,
            false,
            true,
            "OK"
    );

    @Mock
    private Win32UserAccountService service;

    @InjectMocks
    private Win32UserAccountController controller;

    @Test
    void test_getAll_returnsServiceResult() {

        List<Win32UserAccount> expected =
                Collections.singletonList(expectedUser);

        when(service.get(15L)).thenReturn(expected);

        List<Win32UserAccount> response = controller.getAll();

        assertThat(response).containsExactly(expectedUser);

        verify(service).get(15L);
        verifyNoMoreInteractions(service);
    }
}
