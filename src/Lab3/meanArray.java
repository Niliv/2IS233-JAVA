package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class meanArray {
    
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
    
    public static int mean(int[] numbers){
        
        int sum = 0;
        for(int n : numbers){
                sum += n;
        }
        return sum/numbers.length;
    }

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
