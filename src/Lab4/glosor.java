package Lab4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 
 * Main class for the spell checking program.
 */

class glosor{

 
    public static void main(String[] args) {
        program();
    }
    
    /*
     * The main body of the program. It executes the preperations and the main loop of the program.
     */
    public static void program() {

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
            String guess = scanner.nextLine();
            

            if(guess.equals("Q")){
                exit(nr_correct, i);
            }

            int result = spell_checker.check_spelling(guess, words[1]);

            if(result == 0){
                System.out.printf("Fel! %d rätt av %d ord.\n", nr_correct, i);
            }

            else if(result == 1){
                nr_correct++;
                System.out.printf("Korrekt! %d rätt av %d ord.\n", nr_correct, i);
            }

            else if(result == 2){
                System.out.printf("Nästan rätt. Korrekt svar är %s.\n", words[1]);
            }
        
        }

        exit(nr_correct, 10);

    }


    /*
     * Method to exit the program.
     * 
     * @param correct   Number of correct guesses.
     * @param total     Number of questions asked.
     */
    static void exit(int correct, int total){
        System.out.printf("Du svarade på totalt %d glosor och hade %d rätt. Välkommen åter!", total, correct);
        
        System.exit((0));
    }
}