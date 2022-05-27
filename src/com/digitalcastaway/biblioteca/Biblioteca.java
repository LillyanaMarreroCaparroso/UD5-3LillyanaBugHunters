package com.digitalcastaway.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Biblioteca {
    private String name;
    private ArrayList<Integer> catalogoLibros;

    public Biblioteca(String name) {
        this.name = name;
                                                    //esto esta bien
        this.catalogoLibros = new ArrayList<String>(Arrays.stream(Catalogo.libros).toList());
    }

    public void showCatalog() {
        Iterator<String> it = catalogoLibros.iterator();
        System.out.println("################################");
        System.out.println("# Mostrando catálogo de libros #");
        System.out.println("################################");

        int contador = 0;

        while(it.next()) {
            System.out.println(contador + " --> " + it.hasNext());
            contador--;
        }
    }

    public String prestarLibro(int posicion) {
        return catalogoLibros.remove(posicion);
    }

    public String prestarLibroAleatorio() {
        int posicionAleatoria = (int) (Math.random() * this.catalogoLibros.size());
        return prestarLibro(posicionAleatoria);
    }

    public void devolverLibro(String titulo) {
        catalogoLibros.add(titulo);
    }
}
