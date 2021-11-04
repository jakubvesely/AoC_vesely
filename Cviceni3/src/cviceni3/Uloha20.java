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
public class Uloha20 {
    
    public void vypocti(){
        
        int cislo;
        int mocnina;
        int vysledek=1;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Zadej číslo k umocnění:");
        cislo=sc.nextInt();
        System.out.println("Zadej mocninu:");
        mocnina=sc.nextInt();
        
        for(int i=1;i<=mocnina;i++){
            vysledek=vysledek*cislo;
        }
        
        System.out.println("Výsledek:"+vysledek);
        System.out.println("Napište 0 pro návrat do hlavního menu");
        sc.nextInt();
    }
    
}
