package MOBLIMA.configurables;

public class peakPricing {
    private static double nonPeakMultiplier;
    private static double peakMultiplier;

    public peakPricing(double n, double p) {
        nonPeakMultiplier = n;
        peakMultiplier = p;
    }

    public static double getNonPeakMultiplier() {
        return nonPeakMultiplier;
    }

    public static double getPeakMultiplier() {
        return peakMultiplier;
    }

    public void setNonPeakMultiplier(double newNonPeak) {
        nonPeakMultiplier = newNonPeak;
    }

    public void setPeakMultiplier(double newPeak) {
        peakMultiplier = newPeak;
    }
}
