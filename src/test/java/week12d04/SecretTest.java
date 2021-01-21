package week12d04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecretTest {

    @Test
    void loadSecret() {
        Secret secret = new Secret();
        secret.loadSecret();
    }
}