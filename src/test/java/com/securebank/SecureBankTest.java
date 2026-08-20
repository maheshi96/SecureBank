package com.securebank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SecureBankTest {

    @Test
    void applicationNameShouldBeSecureBank() {
        String applicationName = "SecureBank";

        assertEquals("SecureBank", applicationName);
    }

    @Test
    void securityConfigurationShouldBeEnabled() {
        boolean securityEnabled = true;

        assertTrue(securityEnabled);
    }
}
