package it.alessandrocucci.example;

import it.alessandrocucci.comuniprovince.Provincia;

public class Example {

    public static void main(String[] args) {

        Provincia provincia = new Provincia();
        String risposta = provincia.getAll("Lecce");
        System.out.println(risposta);

    }
}