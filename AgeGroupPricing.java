public class AgeGroupPricing {
    private double priceOfChild;
    private double priceOfAdult;
    private double priceOfSnrCitizen;

    public AgeGroupPricing(double priceOfAdult, double priceOfChild, double priceOfSnrCitizen)
    {
        this.priceOfAdult = priceOfAdult;
        this.priceOfChild = priceOfChild;
        this.priceOfSnrCitizen = priceOfSnrCitizen;
    }

    public double getPriceOfChild()
    {
        return priceOfChild;
    }

    public double getPriceOfAdult()
    {
        return priceOfAdult;
    }

    public double getPriceOfSnrCitizen()
    {
        return priceOfSnrCitizen;
    }

    public void setPriceOfChild(double price)
    {
        this.priceOfChild = price;
    }

    public void setPriceOfAdult(double price)
    {
        this.priceOfAdult = price;
    }

    public void setPriceOfSnrCitizen(double price)
    {
        this.priceOfSnrCitizen = price;
    }

}
