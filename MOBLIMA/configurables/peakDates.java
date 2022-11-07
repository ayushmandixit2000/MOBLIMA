package MOBLIMA.configurables;

public class peakDates {
    private int[] peakDates;

    public peakDates(int[] p) {
        peakDates = p;
    }

    public int[] getPeakDates() {
        return peakDates;
    }

    public void setPeakDates(int[] peakDates) {
        this.peakDates = peakDates;
    }

    public boolean isPeak(int date) {
        for (int i = 0; i < peakDates.length; i++) {
            if (date == peakDates[i]) {
                return true;
            }
        }
        return false;
    }
}
