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
public class Cviceni3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int vstup = 1;

        while (vstup != 0) {
            System.out.println("");
            System.out.println("Vyber číslo zadané úlohy:");
            System.out.println("0 - Konec programu");
            System.out.println("18 - Počet, součet a průměr řady čísel");
            System.out.println("19 - Faktoriál čísla");
            System.out.println("20 - Výpočet celočíselné mocniny");
            System.out.println("21 - Výpočet dělitelů z čísla");
            System.out.println("22 - Určení zda je číslo prvočíslo");
            System.out.println("23 - Rozklad čísla na součin prvočísel");
            System.out.println("34 - Výpis trojuhelníku");
            

            Scanner sc = new Scanner(System.in);

            vstup = sc.nextInt();
            System.out.println("");

            switch (vstup) {
                case 18:
                    Uloha18 u18 = new Uloha18();
                    u18.vypocti();
                    break;
                case 19:
                    Uloha19 u19 = new Uloha19();
                    u19.vypocti();
                    break;
                case 20:
                    Uloha20 u20 = new Uloha20();
                    u20.vypocti();
                    break;
                case 21:
                    Uloha21 u21 = new Uloha21();
                    u21.vypocti();
                    break;
                case 22:
                    Uloha22 u22 = new Uloha22();
                    u22.vypocti();
                    break;
                case 23:
                    Uloha23 u23 = new Uloha23();
                    u23.vypocti();
                    break;
                    case 34:
                    Uloha34 u34 = new Uloha34();
                    u34.vypocti();
                    break;
                    
            }
        }

    }

}
