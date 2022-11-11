package MOBLIMA.dataStructure;

public class MovieGoer {
    private String userId;
    private String name;
    private int mobileNumber;
    private String email;

    /**
     * @param u- String denoting the user's id (name + phone number)
     * @param n- String denoting the user's name
     * @param m- int denoting the user's mobile number
     * @param e- String denoting the user's email address
     */
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
