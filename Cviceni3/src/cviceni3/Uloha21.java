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
public class Uloha21 {

    public void vypocti() {

        Scanner sc = new Scanner(System.in);

        int vstup;
        int pocet = 0;
        int i = 2;

        System.out.println("Zadejte číslo:");
        vstup = sc.nextInt();

        System.out.println("Zadané číslo je dělitelné čísly:");
        while (i <= (vstup/2)) {
            if ((vstup % i) == 0) {
                pocet++;
                System.out.println(i);
            }
            i++;
        }

        System.out.printf("Celkem %d kladných dělitelů %n", pocet);
        System.out.println("Napište 0 pro návrat do hlavního menu");
        sc.nextInt();
    }

}
