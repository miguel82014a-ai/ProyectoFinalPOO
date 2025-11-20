/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author migue
 */
public class PrestamoTest {
    @Test
    void testPrestamoInterfaceIsImplemented() {
        Libro libro = new Libro(1, "Test", "Test", "Test");
        assertTrue(libro instanceof Prestamo, "La clase Libro debe implementar la interfaz Prestamo");
    }
}
