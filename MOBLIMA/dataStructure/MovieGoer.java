package MOBLIMA.dataStructure;

/**
 * Represents a MovieGoer that has been registered with MOBLIMA app.
 * Each MovieGoer can use the customer panel of the MOBLIMA app.
 * 
 */

public class MovieGoer {
    /**
     * The userId of the MovieGoer.
     * This is obtained from concatenating the MovieGoer's namd and mobile number.
     */
    private String userId;

    /**
     * The name of the MovieGoer.
     */
    private String name;

    /**
     * The mobile number of the MovieGoer.
     */
    private int mobileNumber;

    /**
     * The email address of the MovieGoer.
     */
    private String email;

    /**
     * Creates a new MovieGoer with the following attributes.
     * 
     * @param u- This MovieGoer's userId.
     * @param n- This MovieGoer's name.
     * @param m- This MovieGoer's mobile number.
     * @param e- This MovieGoer's email address.
     */
    public MovieGoer(String u, String n, int m, String e) {
        userId = u;
        name = n;
        mobileNumber = m;
        email = e;
    }

    /**
     * Gets the userId of this MovieGoer.
     * 
     * @return This MovieGoer's userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the name of this MovieGoer.
     * 
     * @return This MovieGoer's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the mobile number of this MovieGoer.
     * 
     * @return This MovieGoer's mobile number.
     */
    public int getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Gets the email address of this MovieGoer.
     * 
     * @return This MovieGoer's email address.
     */
    public String getEmail() {
        return email;
    }
}
