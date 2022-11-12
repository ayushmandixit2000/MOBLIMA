package MOBLIMA.configurables;

/**
 * Helper class to provide configurable view options for top 5 movie rankings.
 */
public class rankStatus {
    /**
     * The index view ranking status (0: Not allowed, 1: By Sales only, 2: By
     * Ranking only, 3: Both).
     */
    private static int status = 3;

    /**
     * Gets the index view ranking status.
     * 
     * @return Index view ranking staus.
     */
    public static int getStatus() {
        return status;
    }

    /**
     * Chages the index view ranking status.
     * 
     * @param status New index view ranking status.
     */
    public static void setStatus(int status) {
        rankStatus.status = status;
    }

}
