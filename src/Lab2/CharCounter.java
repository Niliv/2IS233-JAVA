package Lab2;
import java.util.Scanner;

// En klass som ger ut information om en mening och ett tecken.
// Ber användaren om båda och ger sen informationen till det användaren angett.
public class CharCounter {

    public static void main(String[] args) {
        // Initialisering av all variabler.
        String sentenceInput, tempInput;
        char charInput = ' ';
        boolean correctInput = false;
        int length, firstIndex, lastIndex;
        int number = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Skriv in en mening:");
        sentenceInput = input.nextLine();
        
        // Förväntar oss bara ett tecken, om vi får fler så frågar vi igen. 
        while(!correctInput){
            System.out.println("Skriv in ett tecken:");
            tempInput = input.nextLine();
            if(tempInput.length()==1){
                charInput = tempInput.charAt(0);
                correctInput = true;
            }
        }
        
        input.close();

        // Ta fram längden av mening.
        length = sentenceInput.length();

        // Ta fram antalet gånger tecknet förekommer i meningen.
        for(char bok : sentenceInput.toCharArray()){
            if(bok == charInput){
                number++;
            }
        }
        // Ta fram index.
        firstIndex = sentenceInput.indexOf(charInput);
        lastIndex = sentenceInput.lastIndexOf(charInput);
        

        System.out.printf("Mening har totalt %d tecken.\n", length);
        System.out.printf("Tecknet %c förekommer %d gånger.\n", charInput, number);
        System.out.printf("Första gången på indexplats %d\n", firstIndex);
        System.out.printf("Sista gången på indexplats %d.", lastIndex);

    }

}
