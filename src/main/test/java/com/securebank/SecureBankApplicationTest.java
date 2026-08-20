package com.securebank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Minimal Spring Boot smoke test.
 *
 * This satisfies the Surefire "unit test" gate in the DevSecOps pipeline,
 * which requires at least one class matching a *Test.java pattern under
 * src/test/java. It verifies that the full Spring application context can
 * start without errors (all beans wire up correctly).
 *
 * Replace or extend this with real unit tests for your services and
 * controllers as the project grows.
 */
@SpringBootTest
class SecureBankApplicationTests {

    @Test
    void contextLoads() {
        // Intentionally empty: if the Spring context fails to start,
        // this test fails automatically.
    }
}