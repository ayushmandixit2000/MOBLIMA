public class movieReviews {
    private Review[] reviews;

    public movieReviews(Review[] reviews) {
        this.reviews = reviews;
    }

    public Review[] getReviews() {
        return reviews;
    }

    public String getOverallRating() {
        if (reviews.length <= 1) {
            return "NA";
        } else {
            int score = 0;
            for (int i = 0; i < reviews.length; i++) {
                score += reviews[i].getRating();
            }
            return ((Integer) score).toString();
        }
    }
}