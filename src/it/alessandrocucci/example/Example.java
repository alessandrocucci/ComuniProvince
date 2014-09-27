package it.alessandrocucci.example;

import it.alessandrocucci.comuniprovince.Comune;
import it.alessandrocucci.comuniprovince.Provincia;

import java.util.Scanner;

public class Example {

    public static void main(String[] args) {

        Provincia provincia = new Provincia();
        Comune comune = new Comune();

        Scanner scan= new Scanner(System.in);
        System.out.print("Inserisci un comune: ");
        String text= scan.nextLine();


        String risposta1 = comune.getNomeProvincia(text);
        System.out.println(text + " fa parte della provincia di " + risposta1);
        System.out.println();
        System.out.println("I comuni della provincia di " + risposta1 + " sono:");
        String comuni = provincia.elencoComuni(risposta1);
        System.out.println(comuni);

    }
}