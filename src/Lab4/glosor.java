package Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

class glosor{
    

    public static void main(String[] args) {

        int nr_correct = 0;
        Scanner scanner =  new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        
        System.out.println("** GLOSÖVNING - ENGELSKA **");
        System.out.println("Skriv det engelska ordet. Avsluta programmet genom att skriva Q.");
        
        for(int i = 1; i < 11; i++){

            String line = reader.read_word(numbers.get(i));
            String[] words = line.split(",");
            System.out.println(words[0] + " :");
            String answer = scanner.nextLine();
            System.out.println(answer);

            if(answer.equals("Q")){
                exit(nr_correct, i);
            }

            
        }

        exit(nr_correct, 10);

    }

    static void exit(int corect, int total){
        System.out.println("Du svarade på totalt " + String.valueOf(total) + " glosor och hade " +
                            String.valueOf(corect) + " rätt. Välkommen åter!");
        
        System.exit((0));
    }

    static void check_spelling(String guess, String correct){
        
    }
}