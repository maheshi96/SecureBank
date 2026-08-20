package com.securebank;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Minimal Spring Boot integration test.
 *
 * This satisfies the Failsafe "integration test" gate in the DevSecOps
 * pipeline (pom.xml is configured to pick up integration-test class names
 * during `mvn verify`). It starts the application
 * on a random port and confirms the Actuator health endpoint responds,
 * proving the app boots end-to-end with the embedded web server.
 *
 * Replace or extend this with real integration tests that exercise your
 * REST controllers and security rules as the project grows.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecureBankApplicationIT {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void healthEndpointIsUp() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/actuator/health", String.class);

        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("UP");
    }
}