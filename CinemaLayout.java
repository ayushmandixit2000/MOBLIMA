public class CinemaLayout {
    private int[][] layout;

    public CinemaLayout() {
        this.layout = new int[9][16];
        for (int i = 0; i < this.layout.length; i++) {
            for (int j = 0; j < this.layout[i].length; j++) {
                this.layout[i][j] = 0;
            }
        }
        this.layout[0][0] = 1;
    }

    // public void getLayout() {
    // for (int i = 0; i < this.layout.length; i++) {
    // for (int j = 0; j < this.layout[i].length; j++) {
    // System.out.printf("%d ", this.layout[i][j]);
    // }
    // System.out.println("");
    // }
    // }

    public int[][] getLayout() {
        return layout;
    }

    public boolean setLayout(int row, int column) {
        if (this.layout[row][column] == 0) {
            this.layout[row][column] = 1;
            return true;
        }
        return false;
    }
}
