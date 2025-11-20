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
public class LibroTest {
    @Test
    void testLibroCreationAndInitialState() {
        Libro libro = new Libro(101, "Cien años de soledad", "Gabriel García Márquez", "Realismo mágico");
        
        assertEquals(101, libro.getCodigo());
        assertEquals("Cien años de soledad", libro.getNombre());
        assertEquals("Gabriel García Márquez", libro.getAutor());
        assertEquals("Realismo mágico", libro.getGenero());
        assertEquals("Disponible", libro.getEstado());
        assertNull(libro.getUsuarioPrestamo());
    }

    @Test
    void testPrestar() {
        Libro libro = new Libro(102, "El amor en los tiempos del cólera", "Gabriel García Márquez", "Novela");
        
        String usuario = "Juan Pérez";
        String fechaPrestamo = "2025-11-20";
        String fechaEntrega = "2025-12-20";
        
        libro.prestar(usuario, fechaPrestamo, fechaEntrega);
        
        assertEquals("Prestado", libro.getEstado());
        assertEquals(usuario, libro.getUsuarioPrestamo());
        assertEquals(fechaPrestamo, libro.getFechaPrestamo());
        assertEquals(fechaEntrega, libro.getFechaEntrega());
    }

    @Test
    void testDevolver() {
        Libro libro = new Libro(103, "Crónica de una muerte anunciada", "Gabriel García Márquez", "Novela corta");
        
        libro.prestar("María López", "2025-11-01", "2025-12-01");
        
        libro.devolver();
        
        assertEquals("Disponible", libro.getEstado());
        assertNull(libro.getUsuarioPrestamo());
        assertNull(libro.getFechaPrestamo());
        assertNull(libro.getFechaEntrega());
    }

    @Test
    void testInfoDisponible() {
        Libro libro = new Libro(104, "La hojarasca", "Gabriel García Márquez", "Novela");
        String expectedInfo = "Código: 104\n" +
                              "Nombre: La hojarasca\n" +
                              "Autor: Gabriel García Márquez\n" +
                              "Género: Novela\n" +
                              "Estado: Disponible";
        
        assertEquals(expectedInfo, libro.info());
    }

    @Test
    void testInfoPrestado() {
        Libro libro = new Libro(105, "El coronel no tiene quien le escriba", "Gabriel García Márquez", "Novela");
        String usuario = "Pedro Gómez";
        String fechaPrestamo = "2025-10-15";
        String fechaEntrega = "2025-11-15";
        
        libro.prestar(usuario, fechaPrestamo, fechaEntrega);
        
        String expectedInfo = "Código: 105\n" +
                              "Nombre: El coronel no tiene quien le escriba\n" +
                              "Autor: Gabriel García Márquez\n" +
                              "Género: Novela\n" +
                              "Estado: Prestado\n" +
                              "Prestado a: Pedro Gómez\n" +
                              "Fecha préstamo: 2025-10-15\n" +
                              "Fecha entrega: 2025-11-15";
        
        assertEquals(expectedInfo, libro.info());
    }  
}
