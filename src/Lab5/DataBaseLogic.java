package Lab5;

import java.io.*;
import java.util.*;

/**
 * Class for all the database logic used for movie searching.
 * 
 */
public class DataBaseLogic {
    private List<Movie> movies;
    private String FILE_NAME = "Database.csv";


    /**
     * Constructor for the logic.
     * Creates a list and loads the movies into it.
     */
    public DataBaseLogic(){
        movies = new ArrayList<>();
        loadMovies();
    }


    /**
     * Adds a movie to the database.
     * 
     * @param movie
     */
    public void addMovie(Movie movie){
        movies.add(movie);
        saveMovies();
    }


    /**
     * Iterates through the list of movies(database) and 
     * searches for movies with specific keywords in the title.
     * 
     * @param title The keyword to search for.
     * @return List of all movies with the keyword in the title.
     */
    public List<Movie> searchTitle(String title){
        List<Movie> result = new ArrayList<>();

        for(Movie movie : movies){
            if(movie.getTitle().toLowerCase().contains(title.toLowerCase())){
                result.add(movie);
            }
        }

        return result;
    }


    /**
     * Iterates through the list of movies(database) and 
     * searches for movies with a minimum rating.
     * 
     * @param rating The minimum rating to use when searching.
     * @return The list of movies with the same or higher rating.
     */
    public List<Movie> searchRating(int rating){
        List<Movie> result = new ArrayList<>();

        for(Movie movie : movies){
            if(movie.getRating() >= rating){
                result.add(movie);
            }
        }

        return result;
    }


    /**
     * Reads the title and rating from the database file.
     * Creates a list of all movies in the database.
     */
    private void loadMovies(){

        String line;

        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            br.readLine();
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
            
                if(parts.length == 2){
                    movies.add(new Movie(parts[0], Integer.valueOf(parts[1])));
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    /**
     * Saves the list of movies to the database by writing over the old one.
     * Used when adding new movies to the database.
     */
    private void saveMovies(){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))){
            for(Movie movie: movies){
                bw.write(movie.getTitle() + "," + String.valueOf(movie.getRating()));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
