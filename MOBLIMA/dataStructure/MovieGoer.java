package MOBLIMA.dataStructure;

public class MovieGoer {
    private String userId;
    private String name;
    private int mobileNumber;
    private String email;

    public MovieGoer(String u, String n, int m, String e) {
        userId = u;
        name = n;
        mobileNumber = m;
        email = e;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}
