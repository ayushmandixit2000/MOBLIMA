package MOBLIMA.configurables;

public class ageGroupPricing {
    private static double priceOfChild;
    private static double priceOfAdult;
    private static double priceOfSnrCitizen;

    public ageGroupPricing() {
        priceOfChild = 5;
        priceOfAdult = 10;
        priceOfSnrCitizen = 7;
    }

    public static double getPriceOfChild() {
        return priceOfChild;
    }

    public static double getPriceOfAdult() {
        return priceOfAdult;
    }

    public static double getPriceOfSnrCitizen() {
        return priceOfSnrCitizen;
    }

    public static void setPriceOfChild(double newChild) {
        priceOfChild = newChild;
    }

    public static void setPriceOfAdult(double newAdult) {
        priceOfAdult = newAdult;
    }

    public static void setPriceOfSnrCitizen(double newSC) {
        priceOfSnrCitizen = newSC;
    }
}
