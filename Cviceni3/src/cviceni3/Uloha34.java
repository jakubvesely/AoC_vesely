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
public class Uloha34 {

    public void vypocti() {

        String st = "";
        int vstup;

        System.out.println("Zadejte výšku trojuhelníku");
        Scanner sc = new Scanner(System.in);
        vstup = sc.nextInt();
        System.out.println("");
        for (int i = 1; i <= vstup; i++) {
            for (int n = 1; n <= i; n++) {
                System.out.print(" *");
            }
            System.out.println("");
        }

        System.out.println("");
        for (int i = 1; i <= vstup; i++) {

            for (int n = 1; n <= (vstup - i); n++) {
                System.out.print(" ");
            }
            for (int n = 1; n <= i; n++) {
                System.out.print(" *");
            }

            System.out.println("");
        }

        System.out.println("");
        System.out.println("Napište 0 pro návrat do hlavního menu");
        sc.nextInt();

    }
}
