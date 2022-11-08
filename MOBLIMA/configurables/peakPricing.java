package MOBLIMA.configurables;

public class peakPricing {
    private static double nonPeakMultiplier;
    private static double peakMultiplier;

    public peakPricing() {
        nonPeakMultiplier = 1;
        peakMultiplier = 1.5;
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
