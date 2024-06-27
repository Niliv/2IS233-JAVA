package Lab1;

import java.util.Scanner;


public class knopToKph {

    // En publik klass som används för att konvertera knop till km/h
    // Tar in en hastighet i knop via standard system in.
    // Skriver sen ut hastigheten i km/h.
    
    public static void main(String[] args){
        double knop, kph;
        
        Scanner input = new Scanner(System.in);

        System.out.println("Skriv in en hastighet i knop:");

        knop = input.nextInt();
        
        input.close();
        kph = knop * 1.852;

        System.out.println(knop + " knop motsvarar " + kph + " km/h");
    }
}