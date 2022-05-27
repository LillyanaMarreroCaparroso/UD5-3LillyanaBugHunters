package com.digitalcastaway.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Biblioteca {
    private String name;
    private ArrayList<String> catalogoLibros;

    public Biblioteca(String name) {
        this.name = name;

        this.catalogoLibros = new ArrayList<String>(Arrays.stream(Catalogo.libros).toList());
    }

    public void showCatalog() {
        Iterator<String> it = catalogoLibros.iterator();
        System.out.println("################################");
        System.out.println("# Mostrando catálogo de libros #");
        System.out.println("################################");

        int contador = 0;

        while(it.hasNext()) {
            String value = it.next();
            System.out.println(contador + " --> " + value);
            contador--;
        }
    }

    public String prestarLibro(int posicion) {
        String libroPrestado = catalogoLibros.remove(posicion);
        return libroPrestado;
    }

    public String prestarLibroAleatorio() {
        int posicionAleatoria = (int) (Math.random() * this.catalogoLibros.size());
        return prestarLibro(posicionAleatoria);
    }

    public void devolverLibro(String titulo) {
        catalogoLibros.add(titulo);
    }
}
