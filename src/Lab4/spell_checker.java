package Lab4;

public class spell_checker {
    
    /*
     * Checks the spelling of the guess. If it is correct, almost correct or wrong. 
     * The criterion for almost correct is set to 75%, but can be changed.
     * 
     * @param   guess   The guess form the user.
     * @param   answer  The correct spelling.
     * @return          Returns an int of value 0,1,2 depending on the result. 0=wrong, 1=correct, 2=almost correct.   
     */
    public static int check_spelling(String guess, String answer) {
        
        if(guess.equals(answer)){
            return 1;
        }
        
        int correct_chars = 0;
        for(int i = 0; i < answer.length(); i++){
            if(i >= guess.length()) continue;
            if(answer.charAt(i) == guess.charAt(i)){
                correct_chars++;
            }
        }

        if (correct_chars / answer.length() > 0.75) return 2;
        
        
        return 0;
    }
}
