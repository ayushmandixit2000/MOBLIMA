enum showStatus {
    Coming_Soon,
    Preview,
    Now_Showing
}

enum movieType {
    Blockbuster,
    ThreeD // 3D cannot
}

enum movieRating {
    G,
    PG,
    PGThirteen,
    NCSixteen,
    MEighteen,
    RTwentyOne // pls add more
}

public class Movie1 {
    private String movieID;
    private String title;
    private showStatus status;
    private String synopsis;
    private String director;
    private String[] cast;
    private movieType type;
    private movieRating rating;
    private int sales;
    private movieReviews reviews;

    public Movie1(String movieID, String title, showStatus status, String synopsis, String director, String[] cast,
            movieType type, movieRating rating, int sales, movieReviews reviews) {
        this.movieID = movieID;
        this.title = title;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.type = type;
        this.rating = rating;
        this.sales = sales;
        this.reviews= reviews;
    }

    public String getMovieID() {
        return movieID;
    }

    public String getTitle() {
        return title;
    }

    public showStatus getStatus() {
        return status;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public String[] getCast() {
        return cast;
    }

    public movieType getType() {
        return type;
    }

    public movieRating getRating() {
        return rating;
    }

    public int getSales() {
        return sales;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(showStatus status) {
        this.status = status;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public void setType(movieType type) {
        this.type = type;
    }

    public void setRating(movieRating rating) {
        this.rating = rating;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
