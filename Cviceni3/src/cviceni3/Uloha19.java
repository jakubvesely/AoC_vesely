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
public class Uloha19 {
    
    public void vypocti(){
        
        int vstup;
        long vysledek=1;
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Zadejte číslo pro výpočet jeho faktoriálu");
        
        vstup=sc.nextInt();
        
        for(int i=2;i<=vstup;i++){
            
            vysledek=vysledek*i;
        }
        System.out.println("Faktoriál zadaného čísla je:"+vysledek);
        System.out.println("Napište 0 pro návrat do hlavního menu");
        vstup=sc.nextInt();
    }
            
    
}
