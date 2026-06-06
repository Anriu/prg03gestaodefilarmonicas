package br.com.ifba;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @BeforeAll
    public static void setup() {
        // Força o Java a aceitar componentes de interface gráfica (Swing/AWT) nos testes
        System.setProperty("java.awt.headless", "false");
    }

    @Test
    void contextLoads() {
    }
}