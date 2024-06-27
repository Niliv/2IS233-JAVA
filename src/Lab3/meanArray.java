package Lab3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class meanArray {
    
    public static void main(String[] args) {

        int total = input("Hur många heltal vill du ange: ");
        
        int[] numbers = new int[total];
        
        for(int i = 0; i<numbers.length; i++){
            numbers[i] = input("Ange heltal " + Integer.toString(i+1) + ":");
        }
    
        int mean = mean(numbers);

        int times = times(numbers);
        
        System.out.printf("Du angav %d tal.\n", numbers.length);
        System.out.printf("Varav %d av talen bara angavs en gång.\n", times);
        System.out.printf("Medelvärdet för talen är %d", mean);


    }

    public static int input(String str){
        Scanner input = new Scanner(System.in);
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

        input.close();
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
        int times = 0; // numbers = [2, 2, 4, 4, 6]
        //int[] banan = new int[numbers.length];

        
        for(int i = 0; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++){
                if(numbers[i] == numbers[j]){
                    continue;
                }
                else{
                    times++;
                }

            }
        }
        return times;
    }
    
}
