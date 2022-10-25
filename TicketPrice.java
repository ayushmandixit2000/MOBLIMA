enum ageCategory {
    Child,
    Adult,
    Senior_Citizen
}

public class TicketPrice {
    private double price;
    private ageCategory age;
    private MovieSlot slot;

    public TicketPrice(double price, ageCategory age, String movieTicketID, MovieSlot slot) {
        this.price = price;
        this.age = age;
        this.slot = slot;
    }

    public double getPrice() { // replace with calculation mechanism
        return price;
    }

    public ageCategory getAge() {
        return age;
    }

}
