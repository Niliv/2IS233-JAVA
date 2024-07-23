package Lab5;

import java.util.*;

public class UI {

    private Scanner scanner;
    private DataBaseLogic logic;


    /**
     * Main UI method. Initializes the logic to be used.
     * Loops the program until users quits.
     */
    public void startUI() {
        logic = new DataBaseLogic();
		scanner = new Scanner(System.in);
		int input;		
		boolean quit = false;

		System.out.println("** MOVIE DATABASE **");

		while(!quit) {			
			input = getNumberInput(scanner, 1, 4, getMainMenu());

			switch(input) {
			case 1: searchTitel(); break;
			case 2: searchReviewScore(); break;
			case 3: addMovie(); break;
			case 4: quit = true; 			
			}
		}
		//Close scanner to free resources
		scanner.close();
	}


    /**
     * Adds a movie to the database with the help of the logic function.
     */
    private void addMovie(){
        System.out.println("Title: ");
        String title = scanner.nextLine();
        int rating = getNumberInput(scanner, 1, 5, "Review score (1 - 5):");

        logic.addMovie(new Movie(title, rating));

    }


    /**
     * Displays the movies matching the keyword. 
     * Uses the logic function and helper function to display movies.
     */
    private void searchTitel(){
        System.out.println("Enter keyword: ");
        String keyword = scanner.nextLine();

        List<Movie> movies = logic.searchTitle(keyword);

        printMovies(movies);
    }


    /**
     * Displays the movies with a minimum rating.
     * Uses the logic function and helper fucntion to display movies.
     */
    private void searchReviewScore(){
        int rating = getNumberInput(scanner, 1, 5, "Enter minimum review score (1-5)");

        List<Movie> movies = logic.searchRating(rating);

        printMovies(movies);
    }

    /**
	 * Get input and translate it to a valid number.
	 * 
	 * @param scanner the Scanner we use to get input 
	 * @param min the lowest correct number
	 * @param max the highest correct number
	 * @param message message to user
	 * @return the chosen menu number 
	 */
    private int getNumberInput(Scanner scanner, int min, int max, String message) {
		int input = -1;

		while(input < 0) {
			System.out.println(message);
			try {
				input = Integer.parseInt(scanner.nextLine().trim());		
			} 
			catch(NumberFormatException nfe) {
				input = -1;
			}
			if(input < min || input > max) {
				System.out.println("Invalid value");
				input = -1;
			}			
		}			
		return input;
	}


    /**
     * Displays a list of movies.
     * 
     * @param movies The list of movies to be displayed. 
     */
    private void printMovies(List<Movie> movies){
        for(Movie movie : movies){
            System.out.printf("Title: %s Review score: %d/5\n", movie.getTitle(), movie.getRating());
        }
    }


    /**
	 * Return the main menu text.
	 * 
	 * @return the main menu text
	 */
	private String getMainMenu() {
		return  "-------------------\n" +
				"1. Search title\n" +
				"2. Search review score\n" +
				"3. Add movie\n" +
				"-------------------\n" + 
				"4. Close program";
	}	
}
