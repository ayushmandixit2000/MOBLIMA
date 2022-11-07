package MOBLIMA.configurables;

public class peakPricing {
    private double nonPeakMultiplier;
    private double peakMultiplier;

    public peakPricing(double n, double p) {
        nonPeakMultiplier = n;
        peakMultiplier = p;
    }

    public double getNonPeakMultiplier() {
        return nonPeakMultiplier;
    }

    public double getPeakMultiplier() {
        return peakMultiplier;
    }

    public void setNonPeakMultiplier(double nonPeakMultiplier) {
        this.nonPeakMultiplier = nonPeakMultiplier;
    }

    public void setPeakMultiplier(double peakMultiplier) {
        this.peakMultiplier = peakMultiplier;
    }
}
