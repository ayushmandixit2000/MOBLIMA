import java.util.Date;

public class MovieSlot {
    private Movie movie;
    private String movieSlotID;
    private boolean isPeak;
    private Date showTime;

    public MovieSlot(Movie movie, String movieSlotID, boolean isPeak, Date showTime) {
        this.movie = movie;
        this.movieSlotID = movieSlotID;
        this.isPeak = isPeak;
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getMovieSlotID() {
        return movieSlotID;
    }

    public boolean getisPeak() {
        return isPeak;
    }

    public Date getShowTime() {
        return showTime;
    }
}
