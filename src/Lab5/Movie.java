
package Lab5;

/**
 * Class for movie objects.
 * 
 */
public class Movie {

    private String title;
    private int rating;


    /**
     * Constructor for the movie objects.
     * 
     * @param title The movie title
     * @param rating The movie rating
     */
    public Movie(String title, int rating){
        this.rating = rating;
        this.title = title;

    }


    /**
     * Gets the title of the movie.
     * 
     * @return Movie title
     */
    public String getTitle(){
        return title;
    }


    /**
     * Gets the rating of the movie.
     * 
     * @return Movie rating
     */
    public int getRating(){
        return rating;
    }
}
