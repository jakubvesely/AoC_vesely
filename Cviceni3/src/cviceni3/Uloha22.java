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
public class Uloha22 {

    public void vypocti() {

        int vstup;
        int i = 2;

        boolean prv = true;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadejte číslo:");
        vstup = sc.nextInt();

        while (prv == true && i < (vstup - 1)) {
            if (vstup % i == 0) {
                prv = false;
            }
            i++;
        }

        if (prv == true) {
            System.out.println("Číslo je prvočíslo");
        } else {
            System.out.println("Číslo není prvočíslo");
        }
        System.out.println("Napište 0 pro návrat do hlavního menu");
        sc.nextInt();
    }

}
