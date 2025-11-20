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

class ItemBibliotecaImpl extends ItemBiblioteca {
public ItemBibliotecaImpl(int codigo, String nombre, String estado) {
        super(codigo, nombre, estado);
    }

    @Override
    public String info() {
        return "Implementación de prueba";
    }
}

public class ItemBibliotecaTest {

    @Test
    void testItemBibliotecaCreation() {
        ItemBiblioteca item = new ItemBibliotecaImpl(500, "Revista Científica", "Disponible");
        
        assertEquals(500, item.getCodigo());
        assertEquals("Revista Científica", item.getNombre());
        assertEquals("Disponible", item.getEstado());
    }

    @Test
    void testSetters() {
        ItemBiblioteca item = new ItemBibliotecaImpl(501, "Artículo", "Disponible");
        
        item.setEstado("Prestado");        
        assertEquals("Prestado", item.getEstado());
    }
}
