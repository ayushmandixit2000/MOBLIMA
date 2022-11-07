package MOBLIMA.configurables;

public class peakDates {
    private static int[] peakDates;

    public peakDates(int[] p) {
        peakDates = p;
    }

    public int[] getPeakDates() {
        return peakDates;
    }

    public void setPeakDates(int[] peakDates) {
        this.peakDates = peakDates;
    }

    public static boolean isPeak(int date) {
        for (int i = 0; i < peakDates.length; i++) {
            if (date == peakDates[i]) {
                return true;
            }
        }
        // TODO check for weekends
        // TODO check for timing
        return false;
    }
}
