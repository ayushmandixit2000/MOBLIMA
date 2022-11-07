package MOBLIMA.configurables;

public class ageGroupPricing {
    private double priceOfChild;
    private double priceOfAdult;
    private double priceOfSnrCitizen;

    public ageGroupPricing(double c, double a, double s) {
        priceOfChild = c;
        priceOfAdult = a;
        priceOfSnrCitizen = s;
    }

    public double getPriceOfChild() {
        return priceOfChild;
    }

    public double getPriceOfAdult() {
        return priceOfAdult;
    }

    public double getPriceOfSnrCitizen() {
        return priceOfSnrCitizen;
    }

    public void setPriceOfChild(double priceOfChild) {
        this.priceOfChild = priceOfChild;
    }

    public void setPriceOfAdult(double priceOfAdult) {
        this.priceOfAdult = priceOfAdult;
    }

    public void setPriceOfSnrCitizen(double priceOfSnrCitizen) {
        this.priceOfSnrCitizen = priceOfSnrCitizen;
    }
}
