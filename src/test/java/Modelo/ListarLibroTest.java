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
public class ListarLibroTest {
    @Test
    void testListarArregloConLibros() {
        Libro libro1 = new Libro(1, "El extranjero", "Albert Camus", "Novela");
        Libro libro2 = new Libro(2, "El príncipe", "Nicolás Maquiavelo", "Política");
        Libro[] libros = {libro1, libro2};
        ListarLibro listarLibro = new ListarLibro();

        String[] resultado = listarLibro.listarArreglo(libros);

        assertNotNull(resultado);
        assertEquals(2, resultado.length);
        assertEquals("1 - El extranjero (Disponible)", resultado[0]);
        assertEquals("2 - El príncipe (Disponible)", resultado[1]);
    }

    @Test
    void testListarArregloConArregloVacio() {
        Libro[] libros = {};
        ListarLibro listarLibro = new ListarLibro();

        String[] resultado = listarLibro.listarArreglo(libros);

        assertNotNull(resultado);
        assertEquals(0, resultado.length);
    }

    @Test
    void testListarArregloConLibroPrestado() {
        Libro libro = new Libro(3, "Crimen y castigo", "Fiódor Dostoievski", "Novela");
        libro.prestar("Usuario", "FechaP", "FechaE");
        Libro[] libros = {libro};
        ListarLibro listarLibro = new ListarLibro();

        String[] resultado = listarLibro.listarArreglo(libros);

        assertNotNull(resultado);
        assertEquals(1, resultado.length);
        assertEquals("3 - Crimen y castigo (Prestado)", resultado[0].split(" \\| ")[0]);
    }
}
