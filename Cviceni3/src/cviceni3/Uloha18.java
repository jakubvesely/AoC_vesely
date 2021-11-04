/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cviceni3;

import java.util.Scanner;

/**
 *
 * @author jakub.vesely
 */
public class Uloha18 {

    public void vypocti() {

        int pocet = 0;
        int vstup = 0;
        int suma = 0;
        String a;

        Scanner sc = new Scanner(System.in);

        System.out.println("Zadej čísla pro operace. Pro vyhodnocení zadej 0 nebo záporné číslo");

        vstup = sc.nextInt();

        while (vstup > 0) {
            pocet++;
            suma = suma + vstup;
            vstup = sc.nextInt();
            
        }

        System.out.println("Počet zadaných čísel:" + pocet);
        System.out.println("Součet zadaných čísel:" + suma);
        System.out.println("Průměr zadaných čísel:" + (suma / pocet));
        System.out.println("Napište 0 pro návrat do hlavního menu");
        sc.nextInt();

    }

}
