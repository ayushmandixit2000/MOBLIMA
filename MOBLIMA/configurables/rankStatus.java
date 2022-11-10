package MOBLIMA.configurables;

public class rankStatus {
    private static int status = 3;

    // 0 is none, 1 is sales, 2 is rating and 3 is both
    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        rankStatus.status = status;
    }

}
