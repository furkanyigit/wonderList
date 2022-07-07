package wonderlist.wonderlist.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.AuthenticationProvider;

import java.net.PasswordAuthentication;

import static org.junit.jupiter.api.Assertions.*;

class SecurityConfigurationTest {

    private SecurityConfiguration securityConfiguration;

    private PasswordAuthentication passwordAuthentication;
    private AuthenticationProvider authenticationProvider;

    @BeforeEach
    public void setUp() throws Exception {
        securityConfiguration = new SecurityConfiguration();
    }

    @Test
    public void passwordEncoder() {
    }

    @Test
    public void authenticationProvider() {
    }

    @Test
    public void configure() {
    }

    @Test
    public void testConfigure() {
    }

    @Test
    public void testConfigure1() {
    }
}