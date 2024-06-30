package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Class for the short program that takes in inputs from the user and returns some information about the input. 
 */
public class meanArray {
    
    /*
     * Asks the user for input and then prints information about it. 
     * The input should be in the form och integers but the program can handle wrong input.
     * The information printed is the mean and the number of unique integers.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int total = input("Hur många heltal vill du ange: ", input);
        

        int[] numbers = new int[total];
        
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = input("Ange heltal " + Integer.toString(i+1) + ":", input);
        }
    
        int mean = mean(numbers);

        int times = times(numbers);
        
        System.out.printf("Du angav %d tal.\n", numbers.length);
        System.out.printf("Varav %d av talen bara angavs en gång.\n", times);
        System.out.printf("Medelvärdet för talen är %d.", mean);

    }

    /*
     * Handels the input from the user.
     * 
     * 
     * @param str   The question for the user.
     * @param input The scanner object.
     * @return      An array of the numbers inputted.
     */
    public static int input(String str, Scanner input){
        
        boolean correctInput = false;
        int value = 0;

        while(!correctInput){
            try{
                System.out.println(str);
                value = input.nextInt();
                correctInput = true;
            }
            catch(InputMismatchException e){
                System.out.println("Ogiltigt värde");
                input.next();
            }

        }

        return value;
    }

    /*
     * Calculates the mean of the numbers given
     * 
     * @param numbers   Array of numbers to calculate mean from.
     * @return          The mean.
     */
    public static int mean(int[] numbers){
        
        int sum = 0;
        for(int n : numbers){
                sum += n;
        }
        return sum/numbers.length;
    }

    /*
     * Counts the total number of unique numbers.
     * 
     * @param numbers   Array of numbers to calculate from.
     * @return          The number of unique numbers.
     */
    public static int times(int[] numbers){
        int times = 0; 
    
        for(int i = 0; i < numbers.length; i++){
            boolean duplicates = false;
            for(int j = 0; j < numbers.length; j ++){
                if(i == j) continue;
                
                if (numbers[i] == numbers[j]){
                    System.out.println(numbers[i]);
                    System.out.println(numbers[j]);
                    duplicates = true;
                    break;
                }
            }
            if (!duplicates) times++;
        }

        return times;
    }
    
}
