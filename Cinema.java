enum CinemaClass {
    Default,
    Platinum_Movie_Suite
}

enum CinemaCode {
    XAA,
    XAB,
    XAC,
    XBA,
    XBB,
    XBC
}

public class Cinema {
    private CinemaLayout layout = new CinemaLayout();
    private CinemaClass CinClass;
    private CinemaCode CinCode;
    private Cineplex cineplex;

    public Cinema(CinemaClass Class, CinemaCode Code, Cineplex cineplex, CinemaLayout layout) {
        this.CinClass = Class;
        this.CinCode = Code;
        this.cineplex = cineplex;
        this.layout = layout;
    }

    public CinemaClass getCinClass() {
        return CinClass;
    }

    public CinemaCode getCinCode() {
        return CinCode;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public int[][] getLayout() {
        return layout.getLayout();
    }

    public boolean setLayout(int row, int column) {
        return layout.setLayout(row, column);
    }

}
