public class MovieTicket {
    private String movieTicketID;
    private TicketPrice ticketPrice;

    public MovieTicket(String movieTicketID, TicketPrice ticketPrice) {
        this.movieTicketID = movieTicketID;
        this.ticketPrice = ticketPrice;
    }

    public String getMovieTicketID() {
        return movieTicketID;
    }
    public double getPrice(){
        return ticketPrice.getPrice();
    }

}
