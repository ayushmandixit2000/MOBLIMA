public class MovieGoer {
    private String name;
    private int mobileNumber;
    private String email;

    public MovieGoer(String name, int mobileNumber, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public String getName() { //why is getName written as boolean on the UML?
        return name; 
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}
