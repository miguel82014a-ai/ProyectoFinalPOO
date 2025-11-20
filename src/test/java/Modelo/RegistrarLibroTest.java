/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Modelo;

import javax.swing.JOptionPane;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.swing.JOptionPane;
import org.junit.jupiter.api.extension.ExtendWith;
/**
 *
 * @author migue
 */
public class RegistrarLibroTest {
@ExtendWith(MockitoExtension.class)

    @Test
    void testAgregarUnLibro() {
        Libro[] librosIniciales = {
            new Libro(1, "Existente 1", "Autor 1", "G1"),
            new Libro(2, "Existente 2", "Autor 2", "G2")
        };
        RegistrarLibro registrar = new RegistrarLibro();

        try (MockedStatic<JOptionPane> mocked = Mockito.mockStatic(JOptionPane.class)) {
            mocked.when(() -> JOptionPane.showInputDialog("¿Cuántos libros desea registrar?")).thenReturn("1");
            
            mocked.when(() -> JOptionPane.showInputDialog("Código:")).thenReturn("3");
            mocked.when(() -> JOptionPane.showInputDialog("Nombre:")).thenReturn("Nuevo Libro");
            mocked.when(() -> JOptionPane.showInputDialog("Autor:")).thenReturn("Nuevo Autor");
            mocked.when(() -> JOptionPane.showInputDialog("Género:")).thenReturn("Nuevo Género");
            
            Libro[] librosFinales = registrar.agregar(librosIniciales);

            assertEquals(librosIniciales.length + 1, librosFinales.length);
            
            assertEquals(1, librosFinales[0].getCodigo());
            
            Libro nuevoLibro = librosFinales[2];
            assertEquals(3, nuevoLibro.getCodigo());
            assertEquals("Nuevo Libro", nuevoLibro.getNombre());
            assertEquals("Nuevo Autor", nuevoLibro.getAutor());
            assertEquals("Nuevo Género", nuevoLibro.getGenero());
            
            mocked.verify(() -> JOptionPane.showMessageDialog(null, "Libros agregados con éxito."));
        }
    }

    @Test
    void testAgregarCeroLibros() {
        Libro[] librosIniciales = {new Libro(1, "Existente", "Autor", "G")};
        RegistrarLibro registrar = new RegistrarLibro();

        try (MockedStatic<JOptionPane> mocked = Mockito.mockStatic(JOptionPane.class)) {
            mocked.when(() -> JOptionPane.showInputDialog("¿Cuántos libros desea registrar?")).thenReturn("0");
            
            Libro[] librosFinales = registrar.agregar(librosIniciales);

            assertEquals(librosIniciales.length, librosFinales.length);
            
            mocked.verify(() -> JOptionPane.showMessageDialog(null, "Libros agregados con éxito."));
        }
    }
}
